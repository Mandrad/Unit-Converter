/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miage.unitconverter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class represent our test in the class System
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 */
public class SystemTest {

    public SystemTest() {
    }

    /**
     * Test of addType method, of class System.
     */
    @Test
    public void testAddType() {
        Type type = new Type("longueur", "m");
        System instance = new System("International");
        instance.addType(type);
        assertTrue(instance.getTypeList().contains(type));
    }

    /**
     * Test of removeType method, of class System.
     */
    @Test
    public void testRemoveType() {
        Type type = new Type("longueur", "m");
        System instance = new System("International");
        instance.addType(type);
        boolean expResult = true;
        boolean result = instance.removeType("longueur");
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class System.
     */
    @Test
    public void testGetName() {
        System instance = new System("International");
        String expResult = "International";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class System.
     */
    @Test
    public void testSetName() {
        String name = "International";
        System instance = new System("");
        instance.setName(name);
        assertEquals("International", instance.getName());
    }

    /**
     * Test of getTypeList method, of class System.
     */
    @Test
    public void testGetTypeList() {
        System instance = new System("International");
        Type longueur = new Type("longueur", "m");
        Type poids = new Type("poids", "g");
        List<Type> liste = new ArrayList<Type>();
        liste.add(longueur);
        liste.add(poids);
        instance.setTypeList(liste);
        List<Type> result = instance.getTypeList();
        assertEquals(liste, result);
    }
}
