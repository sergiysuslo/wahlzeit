package org.wahlzeit.model;

public class Coordinate {

    private double x,y,z;

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getCoordX(){
        return this.x;
    }
    public double getCoordY(){
        return this.y;
    }
    public double getCoordZ(){
        return this.z;
    }
    
    //get cartesian distance 
    public double getDistance(Coordinate coord){
        double dist = Math.pow(coord.x-this.x,2) + Math.pow(coord.y-this.y,2) + Math.pow(coord.z-this.z,2);
        return Math.sqrt(dist);
    }

    public boolean isEqual(Coordinate coord){
        return (this.x == coord.x && this.y == coord.y && this.z == coord.z);
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Coordinate){
            return this.isEqual((Coordinate) object);
        }
        return false;
    }
}