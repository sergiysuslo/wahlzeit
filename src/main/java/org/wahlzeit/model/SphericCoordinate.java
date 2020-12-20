package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{

    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException{
        this.phi    = phi;
        this.theta  = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException, NullPointerException{
        assertClassInvariants();

        double x = this.getRadius() * Math.sin(this.getTheta()) * Math.cos(this.getPhi());
        double y = this.getRadius() * Math.sin(this.getTheta()) * Math.sin(this.getPhi());
        double z = this.getRadius() * Math.cos(this.getTheta());

        CartesianCoordinate cartesian = new CartesianCoordinate(x, y, z);
        assertNoNullPointer(cartesian);

        assertClassInvariants();
        return cartesian;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coord) throws IllegalStateException {
        assertClassInvariants();

        double deltaPhi = Math.abs(this.asSphericCoordinate().getPhi() 
                                  - coord.asSphericCoordinate().getPhi());
        assert Double.isFinite(deltaPhi);

        double centralAngle = Math.acos(Math.sin(this.asSphericCoordinate().getTheta())
                                * Math.sin(coord.asSphericCoordinate().getTheta())
                            + Math.sin(this.asSphericCoordinate().getTheta())
                                * Math.sin(coord.asSphericCoordinate().getTheta())
                            * Math.cos(deltaPhi));
        assert Double.isFinite(centralAngle);

        assertClassInvariants();                    
        return centralAngle;                    
    }

    public double getPhi(){
        return this.phi;
    }
    
    public double getTheta(){
        return this.theta;
    }

    public double getRadius(){
        return this.radius;
    }

    @Override
    public void assertClassInvariants() {
        try {
            assert (Double.isFinite(this.radius) && this.radius >= 0);
            assert (Double.isFinite(this.phi)    && this.phi    >= 0);
            assert (Double.isFinite(this.theta)  && this.theta  >= 0);
        } catch(Exception e) {
            throw new IllegalStateException();
        }
        

    }
    
}
