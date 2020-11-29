package org.wahlzeit.model;

public class Location {
    
    private Coordinate coord;

    public Location(Coordinate coordinate){
        if (coordinate == null){
            throw new IllegalArgumentException("Coordinate for Location is non-existent..");
        }
        this.coord = coordinate;
    }

    public Location(double x, double y, double z){
        if(x == 0 && y == 0 && z == 0){
            throw new IllegalArgumentException("Coordinates for Location can't all be zero..");
        }
        this.coord = new CartesianCoordinate(x, y, z);
    }

    public Coordinate getCoord(){
        return this.coord;
    }


}
