/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        Unit instance = new Unit("°C", decalage, Boolean.TRUE);
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
        String name = "mm²";
        Unit instance = new Unit("mm²", BigDecimal.ZERO, Boolean.TRUE);
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

}
