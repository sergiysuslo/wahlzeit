package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {
    
    private final static double EPSILON = 1E-6;

    SphericCoordinate     coord_1;
    SphericCoordinate     coord_2;
    SphericCoordinate     coord_3;
    SphericCoordinate     coord_4;
    SphericCoordinate     coord_5;
    SphericCoordinate     coord_6;
    CartesianCoordinate   cart_coord_5;


    @Before
    public void setup(){
        coord_1  = SphericCoordinate.getSpheric(1.11, 22.44, 345.3);
        coord_2  = SphericCoordinate.getSpheric(3.11, 26.44, 345.3);
        coord_3  = SphericCoordinate.getSpheric(1.0, 2.0, 3.0);
        coord_4  = SphericCoordinate.getSpheric(1.0, 2.0, 3.0);
    }
    @Test
    public void testCoordinateGetter(){

        assertEquals(3.11, coord_2.getPhi(), EPSILON);
        assertEquals(22.44, coord_1.getTheta(), EPSILON);
        assertEquals(3.0, coord_3.getRadius(), EPSILON);
        
    }

    @Test
    public void testCartesianDistance(){

        coord_5 = SphericCoordinate.getSpheric(5, 500, 20);
        coord_6 = SphericCoordinate.getSpheric(5, 500, 22);
    
        double distFirst = coord_1.getCartesianDistance(coord_2);
        double distSecond = coord_2.getCartesianDistance(coord_1);

        assertEquals(distFirst, distSecond, EPSILON);
    }

    @Test
    public void testEquals(){
        assertFalse(coord_1.equals(coord_2));
        assertFalse(coord_2.equals(coord_1));
        assertTrue(coord_3.equals(coord_4));
        assertTrue(coord_4.equals(coord_3));
    }
}
