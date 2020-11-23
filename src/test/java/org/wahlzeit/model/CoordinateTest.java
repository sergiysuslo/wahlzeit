package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
    
    private final static double EPSILON = 1E-6;

    Coordinate coord_1;
    Coordinate coord_2;
    Coordinate coord_3;
    Coordinate coord_4;

    @Before
    public void setup(){
        coord_1  = new Coordinate(1.11, 22.44, 345.3);
        coord_2  = new Coordinate(3.11, 26.44, 345.3);
        coord_3  = new Coordinate(1.0, 2.0, 3.0);
        coord_4  = new Coordinate(1.0, 2.0, 3.0);
    }
    @Test
    public void testCoordinateGetter(){

        assertEquals(3.11, coord_2.getX(), EPSILON);
        assertEquals(22.44, coord_1.getY(), EPSILON);
        assertEquals(3.0, coord_3.getZ(), EPSILON);
        
    }

    @Test
    public void testDistanceGetter(){
        double expectedDistance = Math.sqrt(20);
        double distFirst = coord_1.getDistance(coord_2);
        double distSecond = coord_2.getDistance(coord_1);

        assertEquals(expectedDistance, distFirst, EPSILON);
        assertEquals(expectedDistance, distSecond, EPSILON);
    }

    @Test
    public void testEquals(){
        assertFalse(coord_1.equals(coord_2));
        assertFalse(coord_2.equals(coord_1));
        assertTrue(coord_3.equals(coord_4));
        assertTrue(coord_4.equals(coord_3));

    }
}
