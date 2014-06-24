/*
 * Copyright (C) 2014 Louis MORIN and S�bastien DUBOIS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
 * 
 * Date of last change : 23/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 15
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
    
    /**
     * Test of removeType method, of class System.
     */
    @Test
    public void testRemoveTypeFalse() {
        Type type = new Type("longueur", "m");
        System instance = new System("International");
        instance.addType(type);
        assertFalse(instance.removeType("largeur"));
    }
}
