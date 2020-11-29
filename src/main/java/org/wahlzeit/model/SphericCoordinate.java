package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements Coordinate{

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
    public double getCartesianDistance(Coordinate coord) {
        return this.asCartesianCoordinate().getCartesianDistance(coord);
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

    @Override
    public boolean isEqual(Coordinate coord) {
        return this.asCartesianCoordinate().equals(coord);
    }

    @Override
    public boolean equals(Object object) {

        if (this == object)
            return true;

        if (object == null)
            return false;

        if (object instanceof Coordinate) {
            return this.isEqual((Coordinate) object);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.asCartesianCoordinate().getX(), 
                            this.asCartesianCoordinate().getY(), 
                            this.asCartesianCoordinate().getZ());
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
