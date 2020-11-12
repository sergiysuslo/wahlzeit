package org.wahlzeit.model;

public class Location {
    
    private Coordinate coord;

    public Location(Coordinate coordinate){
        this.coord = coordinate;
    }

    public Coordinate getCoord(){
        return this.coord;
    }


}
