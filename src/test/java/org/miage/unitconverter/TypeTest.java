package org.miage.unitconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;
import java.util.HashMap;
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
public class TypeTest {
    
    public TypeTest() {
    }
    
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
    public void testGetters() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name,ref);
        assertNotNull(type);
        assertEquals(name, type.getName());
        assertNotNull(type.getCoefficientList());
        assertEquals(BigDecimal.ONE, type.getReference().getCoefficient());
    }
    
    @Test
    public void addCoef(){
        Type type = new Type("longueur", "m");
        type.addCoef("km", BigDecimal.valueOf(0.1));
        assertTrue(type.existInList("km"));
    }
    
    @Test
    public void changeName(){
        Type type = new Type("longueur", "m");
        type.addCoef("km", BigDecimal.valueOf(0.1));
        type.setName("distance");
        assertTrue(type.getName().equalsIgnoreCase("distance"));
    }
    
    @Test
    public void getTheName(){
        Type type = new Type("longueur", "m");
        assertTrue(type.getName().equalsIgnoreCase("longueur"));
    }
    
}
