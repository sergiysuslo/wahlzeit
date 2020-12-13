package org.wahlzeit.model;


public class CartesianCoordinate extends AbstractCoordinate{

    private final static CartesianCoordinate SPHERE_CENTER_POINT = new CartesianCoordinate(0.0, 0.0, 0.0);

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();

        double radius = this.asCartesianCoordinate().getCartesianDistance(SPHERE_CENTER_POINT);

        if(radius == 0) return new SphericCoordinate(0.0, 0.0, 0.0);

        double theta  = Math.acos(this.asCartesianCoordinate().getZ()/radius);
        double phi    = Math.atan2(this.asCartesianCoordinate().getY(), this.asCartesianCoordinate().getX());

        SphericCoordinate spheric = new SphericCoordinate(phi, theta, radius);
        assertNoNullPointer(spheric);

        assertClassInvariants();
        return spheric;
    }

    @Override
    public double getCartesianDistance(Coordinate coord) {
        assertClassInvariants();

        double dist = Math.pow(coord.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
                    + Math.pow(coord.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
                    + Math.pow(coord.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2);
        assert Double.isFinite(dist);            

        double result = Math.sqrt(dist);
        assert Double.isFinite(result);

        assertClassInvariants();
        return result;
    }
    
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override
    public void assertClassInvariants() {
        assert Double.isFinite(this.x);
        assert Double.isFinite(this.y);
        assert Double.isFinite(this.z);

    }



}