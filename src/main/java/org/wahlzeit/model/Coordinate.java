package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    private final static double EPSILON = 1E-6;
    private double x,y,z;

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    
    //get cartesian distance 
    public double getDistance(Coordinate coord){
        double dist = Math.pow(coord.x-this.x,2) + Math.pow(coord.y-this.y,2) + Math.pow(coord.z-this.z,2);
        return Math.sqrt(dist);
    }

    private boolean isEqual(Coordinate coord){

        boolean diff_X = Math.abs(x - coord.x) < EPSILON;
        boolean diff_Y = Math.abs(y - coord.y) < EPSILON;
        boolean diff_Z = Math.abs(z - coord.z) < EPSILON;

        return diff_X && diff_Y && diff_Z;
    }

    @Override
    public boolean equals(Object object){

        if (object == null) return false;

        if(object instanceof Coordinate){
            return this.isEqual((Coordinate) object);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y,z);
    }
}