package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

    private final static double EPSILON = 1E-6;
    private final static CartesianCoordinate SPHERE_CENTER_POINT = new CartesianCoordinate(0.0, 0.0, 0.0);

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coord) {
        double dist = Math.pow(coord.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
                    + Math.pow(coord.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
                    + Math.pow(coord.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2);

        return Math.sqrt(dist);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = this.asCartesianCoordinate().getCartesianDistance(SPHERE_CENTER_POINT);

        if(radius == 0) return new SphericCoordinate(0.0, 0.0, 0.0);

        double theta  = Math.acos(this.asCartesianCoordinate().getZ()/radius);
        double phi    = Math.atan2(this.asCartesianCoordinate().getY(), this.asCartesianCoordinate().getX());
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }

    @Override
    public boolean isEqual(Coordinate coord) {
        boolean diff_X = Math.abs(this.asCartesianCoordinate().getX() - coord.asCartesianCoordinate().getX()) < EPSILON;
        boolean diff_Y = Math.abs(this.asCartesianCoordinate().getY() - coord.asCartesianCoordinate().getY()) < EPSILON;
        boolean diff_Z = Math.abs(this.asCartesianCoordinate().getZ() - coord.asCartesianCoordinate().getZ()) < EPSILON;

        return diff_X && diff_Y && diff_Z;
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

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }


}