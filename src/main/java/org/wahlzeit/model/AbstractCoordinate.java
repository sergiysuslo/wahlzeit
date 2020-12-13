package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {

    private final static double EPSILON = 1E-6;

    
    public abstract CartesianCoordinate asCartesianCoordinate();
    public abstract SphericCoordinate asSphericCoordinate();

    public abstract void assertClassInvariants();  //called is specific subclass, no need to implement here

    protected void assertNoNullPointer(Coordinate coord){
        if(coord == null){
            throw new NullPointerException("Object reference of" + coord + " is null.");
        }
    }


    public double getCartesianDistance(Coordinate coord){
        assertClassInvariants();

        // pre
        assertNoNullPointer(coord);

        double distance = this.asCartesianCoordinate().getCartesianDistance(coord);

        //post
        assert(distance >= 0);

        assertClassInvariants();
        return distance;
    }

    public double getCentralAngle(Coordinate coord){
        assertClassInvariants();

        //pre
        assertNoNullPointer(coord);

        double centralAngle = this.asSphericCoordinate().getCentralAngle(coord);

        //post
        assert(centralAngle >= 0);

        assertClassInvariants();
        return centralAngle;
    }

    public boolean isEqual(Coordinate coord) {
        assertClassInvariants();

        //pre
        assertNoNullPointer(coord);
        boolean diff_X = Math.abs(this.asCartesianCoordinate().getX() - coord.asCartesianCoordinate().getX()) < EPSILON;
        boolean diff_Y = Math.abs(this.asCartesianCoordinate().getY() - coord.asCartesianCoordinate().getY()) < EPSILON;
        boolean diff_Z = Math.abs(this.asCartesianCoordinate().getZ() - coord.asCartesianCoordinate().getZ()) < EPSILON;

        assertClassInvariants();

        return diff_X && diff_Y && diff_Z;
    }

    public boolean equals(Object object) {
        assertClassInvariants();

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
        assertClassInvariants();
        return Objects.hash(this.asCartesianCoordinate().getX(), 
                            this.asCartesianCoordinate().getY(), 
                            this.asCartesianCoordinate().getZ());
    }

   


}
