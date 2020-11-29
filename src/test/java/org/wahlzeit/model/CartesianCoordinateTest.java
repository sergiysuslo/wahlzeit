package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {
    
    private final static double EPSILON = 1E-6;

    CartesianCoordinate coord_1;
    CartesianCoordinate coord_2;
    CartesianCoordinate coord_3;
    CartesianCoordinate coord_4;
    SphericCoordinate   sphere_coord_5;


    @Before
    public void setup(){
        coord_1  = new CartesianCoordinate(1.11, 22.44, 345.3);
        coord_2  = new CartesianCoordinate(3.11, 26.44, 345.3);
        coord_3  = new CartesianCoordinate(1.0, 2.0, 3.0);
        coord_4  = new CartesianCoordinate(1.0, 2.0, 3.0);
    }
    @Test
    public void testCoordinateGetter(){

        assertEquals(3.11, coord_2.getX(), EPSILON);
        assertEquals(22.44, coord_1.getY(), EPSILON);
        assertEquals(3.0, coord_3.getZ(), EPSILON);
        
    }

    @Test
    public void testCartesianDistance(){
        double expectedDistance = Math.sqrt(20);
        double distFirst = coord_1.getCartesianDistance(coord_2);
        double distSecond = coord_2.getCartesianDistance(coord_1);

        assertEquals(expectedDistance, distFirst, EPSILON);
        assertEquals(expectedDistance, distSecond, EPSILON);

        sphere_coord_5 = coord_2.asSphericCoordinate();

        double dist_3 = coord_1.getCartesianDistance(sphere_coord_5);
        double dist_4 = sphere_coord_5.getCartesianDistance(coord_1);

        assertEquals(expectedDistance, dist_3, EPSILON);
        assertEquals(expectedDistance, dist_4, EPSILON);

    }

    @Test
    public void testAsSphericCoordinate(){
        sphere_coord_5 = coord_3.asSphericCoordinate();

        assertFalse(sphere_coord_5.equals(coord_1));
        assertTrue(coord_4.equals(sphere_coord_5));


    }

    @Test
    public void testEquals(){
        assertFalse(coord_1.equals(coord_2));
        assertFalse(coord_2.equals(coord_1));
        assertTrue(coord_3.equals(coord_4));
        assertTrue(coord_4.equals(coord_3));
    }
}
