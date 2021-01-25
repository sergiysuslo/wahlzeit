package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class MonumentManagerTest {

    @Test
    public void testCreateMonument(){
        MonumentManager mm = MonumentManager.getInstance();
        Monument m1 = mm.createMonument("Eiffel Tower", "Tower");
        Monument m2 = mm.createMonument("Devils Tower", "Tower");
        Monument m3 = mm.createMonument("Statue of Liberty", "Statue");
        Monument m4 = mm.createMonument("Columbus", "Statue");

        assertEquals(m1.getType(), m2.getType());
        assertEquals(m3.getType(), m4.getType());

        assertEquals("Eiffel Tower", m1.getName());



    }
    
}
