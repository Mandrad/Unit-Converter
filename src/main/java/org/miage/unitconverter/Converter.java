package org.miage.unitconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sébastien
 */
import java.math.BigDecimal;

public class Converter {

    // Cette fonction est celle qui va être appeler, elle utilise les deux suivantes
    // Dans un premier temps, elle convertie l'unité d'entrée dans la valeur de référence
    // Puis, elle convertie cette nouvelle valeur dans la valeur de sortie souhaitée
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

    //Cette fonction convertie une valeur et un type donné dans la valeur de référence du type
    public BigDecimal convertInToReference(String startUnit, Type type, BigDecimal in) {
        if (type != null && type.isInList(startUnit) != null) {
            return (in.subtract(type.isInList(startUnit).getGap()).divide(type.isInList(startUnit).getCoefficient()));
        }
        return null;
    }
    
    // Cette fonction convertie une valeur de référence en une valeur de sortie donnée
    public BigDecimal convertReferenceToOut(String endUnit, Type type, BigDecimal inToRef) {
        return type.isInList(endUnit).getCoefficient().multiply(inToRef).add(type.isInList(endUnit).getGap());
    }
}
