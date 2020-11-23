package org.wahlzeit.model;

public class Location {
    
    private Coordinate coord;

    public Location(Coordinate coordinate){
        this.coord = coordinate;
    }

    public Location(double x, double y, double z){
        this.coord = new Coordinate(x, y, z);
    }

    public Coordinate getCoord(){
        return this.coord;
    }


}
