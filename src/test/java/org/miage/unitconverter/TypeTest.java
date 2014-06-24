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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class represent our test in the class Type
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 23/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 15
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
    
    @Test
    public void setCoefficientListTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        List<Unit> coefficientList = new ArrayList<>();
        coefficientList.add(new Unit("Kelvin", BigDecimal.ZERO, Boolean.TRUE));
        coefficientList.add(new Unit("Celcuis", BigDecimal.valueOf(0.01), Boolean.FALSE));
        type.setCoefficientList(coefficientList);
        assertTrue(type.getCoefficientList() == coefficientList);
    }

    @Test
    public void addCoefDecalageFalseTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoefDecalage("", BigDecimal.ZERO, BigDecimal.ONE);
        assertFalse(type.addCoefDecalage("", BigDecimal.ZERO, BigDecimal.ONE));
    }

    @Test
    public void modifyCoefFalseTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(100));
        assertFalse(type.modifyCoef("km", BigDecimal.ZERO));
    }

    @Test
    public void modifyGapFalseTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoefDecalage("km", BigDecimal.valueOf(1000), BigDecimal.valueOf(100));
        assertFalse(type.modifyGap("dm", BigDecimal.valueOf(120)));
    }

    @Test
    public void removeCoefTrueTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("KELVIN", BigDecimal.valueOf(10));
        type.addCoef("CELCIUS", BigDecimal.valueOf(100));
        assertTrue(type.removeCoef("KELVIN"));
    }

    @Test
    public void removeCoefFalseTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("Kelvin", BigDecimal.ZERO);
        type.addCoef("Celcuis", BigDecimal.valueOf(0.01));
        assertFalse(type.removeCoef("mm"));
    }

    @Test
    public void getReferenceTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(1000.0));
        type.removeCoef("m");
        assertNull(type.getReference());
    }

    @Test
    public void getCoefficientTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(100.0));
        assertEquals(type.getCoefficient("km"), BigDecimal.valueOf(100.0));
    }
    
    @Test
    public void getCoefficientNullTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNull(type.getCoefficient("MM"));
    }

    @Test
    public void modifyGapTrueTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoefDecalage("KM", BigDecimal.valueOf(1000.0), BigDecimal.valueOf(100.0));
        type.modifyGap("KM", BigDecimal.valueOf(90.0));
        assertEquals(type.getGap("KM"), BigDecimal.valueOf(90.0));
    }
    
    @Test
    public void getGapNullTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNull(type.getGap("MM"));
    }

    @Test
    public void modifyCoefTrueTest() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        BigDecimal cent = BigDecimal.valueOf(100.0);
        type.addCoef("km", cent);
        BigDecimal mille = BigDecimal.valueOf(1000.0);
        type.modifyCoef("km", mille);
        assertEquals(type.getCoefficient("km"), mille);
    }
}
