package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
    patternName = "Value Object",
    participants = {}
)

public final class SphericCoordinate extends AbstractCoordinate{

    private final double phi;
    private final double theta;
    private final double radius;

    private static final HashMap<String, SphericCoordinate> sphericCache = new HashMap<String, SphericCoordinate>();

    public static final SphericCoordinate getSpheric(double phi, double theta, double radius){
        final String myCoordinateString = coordinateToString(phi, theta, radius);

        if(sphericCache.get(myCoordinateString) == null){
            synchronized (SphericCoordinate.class) {
                if(sphericCache.get(myCoordinateString) == null){
                    sphericCache.put(myCoordinateString, new SphericCoordinate(phi, theta, radius));
                }
                return sphericCache.get(myCoordinateString);
            }
        } else {
            return sphericCache.get(myCoordinateString);
        }
    }

    private static final String coordinateToString(double phi, double theta, double radius) {
            return phi + " " + theta + " " + radius;
    }

    private SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException{
        this.phi    = phi;
        this.theta  = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException, NullPointerException{
        assertClassInvariants();

        final double x = this.getRadius() * Math.sin(this.getTheta()) * Math.cos(this.getPhi());
        final double y = this.getRadius() * Math.sin(this.getTheta()) * Math.sin(this.getPhi());
        final double z = this.getRadius() * Math.cos(this.getTheta());

        CartesianCoordinate cartesian = CartesianCoordinate.getCartesian(x, y, z);
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

        final double deltaPhi = Math.abs(this.asSphericCoordinate().getPhi() 
                                  - coord.asSphericCoordinate().getPhi());
        assert Double.isFinite(deltaPhi);

        final double centralAngle = Math.acos(Math.sin(this.asSphericCoordinate().getTheta())
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
