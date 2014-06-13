/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.miage.unitconverter;

import java.math.BigDecimal;

/**
 * This class contain all function who permit the convertion of value
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 */
public class Converter {

    /**
     * This method use the two other function for convert value, It is the only public function.
     * @param startUnit Name of input unit
     * @param in Value of input unit
     * @param type Type of input unit (temperature, distance, ...)
     * @param endUnit Name of the desired output unit
     * @return The convert value
     */
    public BigDecimal convert(String startUnit, BigDecimal in, Type type, String endUnit) {
        if (type.isInList(startUnit) != null && type.isInList(endUnit) != null) {
            if(startUnit.equals(endUnit)){
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
        if (type != null && type.isInList(startUnit) != null) {
            return (in.subtract(type.isInList(startUnit).getGap()).divide(type.isInList(startUnit).getCoefficient()));
        }
        return null;
    }
    
    /**
     * @param endUnit Name of the desired output unit
     * @param type Type of input unit (temperature, distance, ...)
     * @param inToRef Input value convert in the reference of type
     * @return  The convert value of output value
     */
    private BigDecimal convertReferenceToOut(String endUnit, Type type, BigDecimal inToRef) {
        return type.isInList(endUnit).getCoefficient().multiply(inToRef).add(type.isInList(endUnit).getGap());
    }
}
