package org.wahlzeit.model;

import java.util.HashMap;


public final class CartesianCoordinate extends AbstractCoordinate{

    private final static CartesianCoordinate SPHERE_CENTER_POINT = new CartesianCoordinate(0.0, 0.0, 0.0);

    private static final HashMap<String, CartesianCoordinate> cartesianCache = new HashMap<String, CartesianCoordinate>();

    public static final CartesianCoordinate getCartesian(double x, double y, double z){
        final String myCoordinateString = coordinateToString(x, y, z);

        if(cartesianCache.get(myCoordinateString) == null){
            synchronized (CartesianCoordinate.class) {
                if(cartesianCache.get(myCoordinateString) == null){
                    cartesianCache.put(myCoordinateString, new CartesianCoordinate(x, y, z));
                }
                return cartesianCache.get(myCoordinateString);
            }
        } else {
            return cartesianCache.get(myCoordinateString);
        }
    }

    private static final String coordinateToString(double x, double y, double z) {
            return x + " " + y + " " + z;
    }

    private final double x;
    private final double y;
    private final double z;

    private CartesianCoordinate(double x, double y, double z) throws IllegalStateException{
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
    public SphericCoordinate asSphericCoordinate() throws IllegalStateException, NullPointerException {
        assertClassInvariants();

        final double radius = this.asCartesianCoordinate().getCartesianDistance(SPHERE_CENTER_POINT);

        if(radius == 0) return SphericCoordinate.getSpheric(0.0, 0.0, 0.0);

        final double theta  = Math.acos(this.asCartesianCoordinate().getZ()/radius);
        final double phi    = Math.atan2(this.asCartesianCoordinate().getY(), this.asCartesianCoordinate().getX());

        final SphericCoordinate spheric = SphericCoordinate.getSpheric(phi, theta, radius);
        assertNoNullPointer(spheric);

        assertClassInvariants();
        return spheric;
    }

    @Override
    public double getCartesianDistance(Coordinate coord) throws IllegalStateException{
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

        try{
            assert Double.isFinite(this.x);
            assert Double.isFinite(this.y);
            assert Double.isFinite(this.z);
        } catch(Exception e){
            throw new IllegalStateException();
        }
        

    }



}