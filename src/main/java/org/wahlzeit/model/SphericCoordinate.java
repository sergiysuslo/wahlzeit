package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{

    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius){
        this.phi    = phi;
        this.theta  = theta;
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.getRadius() * Math.sin(this.getTheta()) * Math.cos(this.getPhi());
        double y = this.getRadius() * Math.sin(this.getTheta()) * Math.sin(this.getPhi());
        double z = this.getRadius() * Math.cos(this.getTheta());

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coord) {
        double deltaPhi = Math.abs(this.asSphericCoordinate().getPhi() 
                                  - coord.asSphericCoordinate().getPhi());

        return Math.acos(Math.sin(this.asSphericCoordinate().getTheta())
                                * Math.sin(coord.asSphericCoordinate().getTheta())
                       + Math.sin(this.asSphericCoordinate().getTheta())
                                * Math.sin(coord.asSphericCoordinate().getTheta())
                       * Math.cos(deltaPhi));
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
}
