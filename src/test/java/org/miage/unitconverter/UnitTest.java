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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class represent our test in the class Unit
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 23/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 15
 */
public class UnitTest {

    public UnitTest() {
    }

    /**
     * Test of getDecalage method, of class Unit.
     */
    @Test
    public void testGetDecalage() {
        Unit instance = new Unit("m", BigDecimal.ONE, Boolean.TRUE);
        BigDecimal expResult = BigDecimal.ZERO;
        BigDecimal result = instance.getGap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecalage method, of class Unit.
     */
    @Test
    public void testSetDecalage() {
        BigDecimal decalage = BigDecimal.valueOf(22.0);
        Unit instance = new Unit("�C", decalage, Boolean.TRUE);
        instance.setGap(decalage);
        assertEquals(decalage, instance.getGap());
    }

    /**
     * Test of getName method, of class Unit.
     */
    @Test
    public void testGetName() {
        Unit instance = new Unit("m", BigDecimal.ZERO, Boolean.TRUE);
        String expResult = "m".toUpperCase();
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Unit.
     */
    @Test
    public void testSetName() {
        String name = "mm�";
        Unit instance = new Unit("mm�", BigDecimal.ZERO, Boolean.TRUE);
        instance.setName(name);
        assertEquals(name.toUpperCase(), instance.getName());
    }

    /**
     * Test of getCoef method, of class Unit.
     */
    @Test
    public void testGetCoef() {
        Unit instance = new Unit("m", BigDecimal.valueOf(13.0), Boolean.TRUE);
        BigDecimal expResult = BigDecimal.valueOf(13.0);
        BigDecimal result = instance.getCoefficient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCoef method, of class Unit.
     */
    @Test
    public void testSetCoef() {
        BigDecimal coef = BigDecimal.valueOf(3.0);
        Unit instance = new Unit("mm", BigDecimal.ONE, Boolean.TRUE);
        instance.setCoefficient(coef);
        assertEquals(coef, instance.getCoefficient());
    }

    /**
     * Test of isReference method, of class Unit.
     */
    @Test
    public void testIsReference() {
        Unit instance = new Unit("mm", BigDecimal.ONE, Boolean.TRUE);
        Boolean expResult = true;
        Boolean result = instance.isReference();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReference method, of class Unit.
     */
    @Test
    public void testSetReference() {
        boolean ref = false;
        Unit instance = new Unit("mm", BigDecimal.ONE, Boolean.TRUE);
        instance.setReference(ref);
        assertFalse(instance.isReference());
    }

    /**
     * Test of getType method, of class Unit.
     */
    @Test
    public void testGetType() {
        Type type = new Type("longueur", "m");
        Unit instance = new Unit("mm", BigDecimal.ONE, Boolean.TRUE);
        instance.setType(type);
        assertEquals(instance.getType(), type);
    }
}
