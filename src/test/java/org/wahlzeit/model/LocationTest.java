package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    Coordinate coord_1;
    Location   loc_1;
    Location   loc_2;
    Location   loc_3;
    Location   loc_4;
    Location   loc_5;

    @Before
    public void setup(){
       
        coord_1  = CartesianCoordinate.getCartesian(1.0, 2.0, 3.0);
        loc_1    = new Location(coord_1);
        loc_2    = new Location(1.0, 2.0, 3.0);
        loc_3    = new Location(4.4, 5.5, 6.6);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullAsLocationConstructorArgument(){
        
        loc_4 = new Location(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValuesForLocationConstructor(){
        
        loc_5 = new Location(0.0, 0.0, 0.0);
    }


    @Test
    public void testGetCoord(){
        assertTrue(loc_1.getCoord().equals(loc_2.getCoord()));
        assertTrue(loc_2.getCoord().equals(loc_1.getCoord()));
        assertFalse(loc_2.getCoord().equals(loc_3.getCoord()));
        assertFalse(loc_1.getCoord().equals(loc_3.getCoord()));
        
    }
    
}
