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
 * This class represent all of our conversion's test.
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 23/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 15
 */
public class ConversionTest {

    public ConversionTest() {
    }

    /**
     * This test create two units and test the conversion result.
     */
    @Test
    public void simpleConversion() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("m", BigDecimal.valueOf(1000.0), type, "km").compareTo(BigDecimal.ONE) == 0));
    }

    /**
     * This test create two unity and convert number with many digit
     */
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

    /**
     * This method test another conversion
     */
    @Test
    public void refConversion() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("mm", BigDecimal.valueOf(1000));
        assertTrue((conversion.convert("m", BigDecimal.valueOf(22.3), type, "mm").compareTo(BigDecimal.valueOf(22300.0)) == 0));
    }

    /**
     * This method test another conversion with many digit
     */
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

    /**
     * This test convert two unity who are not created
     */
    @Test
    public void inexistUnit() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNull((conversion.convert("dm", BigDecimal.valueOf(0.456), type, "km")));
    }

    /**
     * This test convert with zero
     */
    @Test
    public void coefEqualsZero() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("vm", BigDecimal.valueOf(0));
        assertNull((conversion.convert("km", BigDecimal.valueOf(0), type, "m")));
    }

    /**
     * This test verify the creation of two same unity
     */
    @Test
    public void coefAlreadyExist() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertFalse(type.addCoef("m", BigDecimal.valueOf(10.0)));
    }

    /**
     * This test verify the convertion with gap. For the temperature in this
     * case.
     */
    @Test
    public void temperatureConversion() {
        Converter conversion = new Converter();
        String name = "temperature";
        String ref = "�C";
        Type type = new Type(name, ref);
        type.addCoefDecalage("�F", BigDecimal.valueOf(1.8), BigDecimal.valueOf(32.0));
        type.addCoefDecalage("K", BigDecimal.valueOf(1), BigDecimal.valueOf(273.15));
        assertTrue(conversion.convert("K", BigDecimal.valueOf(300.0), type, "�F").compareTo(BigDecimal.valueOf(80.33)) == 0);
    }
    
    @Test
    public void sameInOutConversionTest() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("m", BigDecimal.ONE, type, "m").compareTo(BigDecimal.ONE) == 0));
    }

    @Test
    public void typeNullConversionTest() {
        Converter conversion = new Converter();
        assertNull(conversion.convert("m", BigDecimal.ONE, null, "km"));
    }
}
