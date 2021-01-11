package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {

    
    public abstract CartesianCoordinate asCartesianCoordinate();
    public abstract SphericCoordinate asSphericCoordinate();

    public abstract void assertClassInvariants();  //called is specific subclass, no need to implement here


    public double getCartesianDistance(Coordinate coord) throws NullPointerException, IllegalStateException{
        assertClassInvariants();

        // pre
        assertNoNullPointer(coord);

        final double distance = this.asCartesianCoordinate().getCartesianDistance(coord);

        //post
        assert(distance >= 0);

        assertClassInvariants();
        return distance;
    }

    public double getCentralAngle(Coordinate coord) throws NullPointerException, IllegalStateException{
        assertClassInvariants();

        //pre
        assertNoNullPointer(coord);

        final double centralAngle = this.asSphericCoordinate().getCentralAngle(coord);

        //post
        assert(centralAngle >= 0);

        assertClassInvariants();
        return centralAngle;
    }

    // comparing coordinates via object reference, as coordinates are value objects
    public boolean isEqual(Coordinate coord) {
        return this == coord;
    }

    public boolean equals(Object object) throws IllegalStateException{
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

    public int hashCode() throws IllegalStateException{
        assertClassInvariants();
        return Objects.hash(this.asCartesianCoordinate().getX(), 
                            this.asCartesianCoordinate().getY(), 
                            this.asCartesianCoordinate().getZ());
    }

    protected void assertNoNullPointer(Coordinate coord){
        if(coord == null){
            throw new NullPointerException("Object reference of" + coord + " is null.");
        }
    }

   


}
