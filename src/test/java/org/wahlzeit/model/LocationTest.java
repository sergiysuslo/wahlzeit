package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    Coordinate coord_1;
    Location   loc_1;
    Location   loc_2;
    Location   loc_3;

    @Before
    public void setup(){
       
        coord_1  = new Coordinate(1.0, 2.0, 3.0);
        loc_1    = new Location(coord_1);
        loc_2    = new Location(1.0, 2.0, 3.0);
        loc_3    = new Location(4.4, 5.5, 6.6);
    }

    @Test
    public void testGetCoord(){
        assertTrue(loc_1.getCoord().equals(loc_2.getCoord()));
        assertTrue(loc_2.getCoord().equals(loc_1.getCoord()));
        assertFalse(loc_2.getCoord().equals(loc_3.getCoord()));
        assertFalse(loc_1.getCoord().equals(loc_3.getCoord()));
        
    }
    
}
