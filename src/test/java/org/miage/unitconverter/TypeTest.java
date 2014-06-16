/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miage.unitconverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class represent our test in the class Type
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 */
public class TypeTest {

    public TypeTest() {
    }

    @Test
    public void testGetters() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNotNull(type);
        assertEquals(name, type.getName());
        assertNotNull(type.getCoefficientList());
        assertEquals(BigDecimal.ONE, type.getReference().getCoefficient());
    }

    @Test
    public void addCoef() {
        Type type = new Type("longueur", "m");
        type.addCoef("km", BigDecimal.valueOf(0.1));
        assertTrue(type.existInList("km"));
    }

    @Test
    public void changeName() {
        Type type = new Type("longueur", "m");
        type.addCoef("km", BigDecimal.valueOf(0.1));
        type.setName("distance");
        assertTrue(type.getName().equalsIgnoreCase("distance"));
    }

    @Test
    public void getTheName() {
        Type type = new Type("longueur", "m");
        assertTrue(type.getName().equalsIgnoreCase("longueur"));
    }

    /**
     * Test of getSystem method, of class Type.
     */
    @Test
    public void testGetSystem() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        System system = new System("Metrique");
        system.addType(type);
        System result = type.getSystem();
        assertEquals(system, result);
    }

    /**
     * Test of setSystem method, of class Type.
     */
    @Test
    public void testSetSystem() {
        System system = new System("Metrique");
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.setSystem(system);
        assertEquals(system, type.getSystem());
    }

    /**
     * Test of getName method, of class Type.
     */
    @Test
    public void testGetName() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        String result = type.getName();
        assertEquals(name, result);
    }

    /**
     * Test of setName method, of class Type.
     */
    @Test
    public void testSetName() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        String name2 = "largeur";
        type.setName(name2);
        assertEquals(type.getName(), name2);
    }
}
