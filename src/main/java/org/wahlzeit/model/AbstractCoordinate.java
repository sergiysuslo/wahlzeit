package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {

    private final static double EPSILON = 1E-6;

    
    public abstract CartesianCoordinate asCartesianCoordinate();
    public abstract SphericCoordinate asSphericCoordinate();

    public double getCartesianDistance(Coordinate coordinate){
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    public double getCentralAngle(Coordinate coordinate){
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }

    public boolean isEqual(Coordinate coord) {
        boolean diff_X = Math.abs(this.asCartesianCoordinate().getX() - coord.asCartesianCoordinate().getX()) < EPSILON;
        boolean diff_Y = Math.abs(this.asCartesianCoordinate().getY() - coord.asCartesianCoordinate().getY()) < EPSILON;
        boolean diff_Z = Math.abs(this.asCartesianCoordinate().getZ() - coord.asCartesianCoordinate().getZ()) < EPSILON;

        return diff_X && diff_Y && diff_Z;
    }

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

    public int hashCode() {
        return Objects.hash(this.asCartesianCoordinate().getX(), 
                            this.asCartesianCoordinate().getY(), 
                            this.asCartesianCoordinate().getZ());
    }



}
