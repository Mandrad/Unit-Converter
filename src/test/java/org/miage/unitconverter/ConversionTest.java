package org.miage.unitconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sébastien
 */
public class ConversionTest {
    
    public ConversionTest() { }
            
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   
    
    @Test
    public void simpleConversion(){
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name,ref);
        type.addCoef("km", BigDecimal.valueOf(0.001)); 
        assertTrue((conversion.convert("m", BigDecimal.valueOf(1000.0), type, "km").compareTo(BigDecimal.ONE) == 0));
    }
    
    @Test
    public void complexConversion() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("mm", BigDecimal.valueOf(10000));
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("mm", BigDecimal.valueOf(238.423), type, "km").compareTo(BigDecimal.valueOf(0.0000238423)) == 0));
    }
    
    @Test 
    public void refConversion() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("mm", BigDecimal.valueOf(1000));
        assertTrue((conversion.convert("m", BigDecimal.valueOf(22.3), type, "mm").compareTo(BigDecimal.valueOf(22300.0)) == 0));
    }
    
    @Test
    public void complexConversion2() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("dm", BigDecimal.valueOf(10));
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("dm", BigDecimal.valueOf(0.456), type, "km").compareTo(BigDecimal.valueOf(0.0000456)) == 0));
    }
    
    @Test
    public void inexistUnit() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNull((conversion.convert("dm", BigDecimal.valueOf(0.456), type, "km")));
    }
    
    @Test
    public void coefEqualsZero() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("vm", BigDecimal.valueOf(0));
        assertNull((conversion.convert("km", BigDecimal.valueOf(0), type, "m")));
    }
    
    @Test
    public void coefAlreadyExist() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertFalse(type.addCoef("m", BigDecimal.valueOf(10.0)));
    }
    
    @Test
    public void temperatureConversion(){
        Converter conversion = new Converter();
        String name = "temperature";
        String ref = "°C";
        Type type = new Type(name, ref);
        type.addCoefDecalage("°F", BigDecimal.valueOf(1.8), BigDecimal.valueOf(32.0));
        type.addCoefDecalage("K", BigDecimal.valueOf(1), BigDecimal.valueOf(273.15));
        assertTrue(conversion.convert("K",BigDecimal.valueOf(300.0), type,"°F").compareTo(BigDecimal.valueOf(80.33))==0);
    }
}
