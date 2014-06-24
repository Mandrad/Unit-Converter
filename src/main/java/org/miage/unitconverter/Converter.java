/*
 * Copyright (C) 2014 Louis MORIN and Sébastien DUBOIS
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

/**
 * This class contain all function who permit the convertion of value
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 17/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 07
 */
public class Converter {

    /**
     * This method use the two other function for convert value, It is the only
     * public function.
     *
     * @param startUnit Name of input unit
     * @param in Value of input unit
     * @param type Type of input unit (temperature, distance, ...)
     * @param endUnit Name of the desired output unit
     * @return The convert value
     */
    public BigDecimal convert(String startUnit, BigDecimal in, Type type, String endUnit) {
        if (type != null && type.isInList(startUnit) != null && type.isInList(endUnit) != null) {
            if (startUnit.equals(endUnit)) {
                return in;
            } else {
                return convertReferenceToOut(endUnit, type, convertInToReference(startUnit, type, in));
            }
        }
        return null;
    }

    /**
     * @param startUnit Name of input unit
     * @param type Type of input unit (temperature, distance, ...)
     * @param in Value of input unit
     * @return The convert value of input to type's reference
     */
    private BigDecimal convertInToReference(String startUnit, Type type, BigDecimal in) {
        return in.subtract(type.isInList(startUnit).getGap()).divide(type.isInList(startUnit).getCoefficient());
    }

    /**
     * @param endUnit Name of the desired output unit
     * @param type Type of input unit (temperature, distance, ...)
     * @param inToRef Input value convert in the reference of type
     * @return The convert value of output value
     */
    private BigDecimal convertReferenceToOut(String endUnit, Type type, BigDecimal inToRef) {
        return type.isInList(endUnit).getCoefficient().multiply(inToRef).add(type.isInList(endUnit).getGap());
    }
}
