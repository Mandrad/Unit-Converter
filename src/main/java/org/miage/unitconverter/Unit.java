/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.miage.unitconverter;

import java.math.BigDecimal;

/**
 *
 * @author MORIN
 */
// Cette classe représente une unité. Celle si contient les informations nécessaire à la conversion
public class Unit {
    
    private String name;
    private BigDecimal coefficient;
    private BigDecimal gap;
    private boolean reference;
    private Type type;

    // On peut créer une unité sans décalage (0 par défaut)
    public Unit(String name, BigDecimal coef, Boolean reference) {
        this.name = name.toUpperCase();
        this.coefficient = coef;
        this.gap = BigDecimal.ZERO;
        this.reference = reference;
        this.type = null;
    }
    
    // Ou avec un décalage
    public Unit(String name, BigDecimal coef, BigDecimal gap, Boolean reference) {
        this.name = name.toUpperCase();
        this.coefficient = coef;
        this.gap = gap;
        this.reference = reference;
        this.type = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getGap() {
        return gap;
    }

    public void setGap(BigDecimal gap) {
        this.gap = gap;
    }

    public boolean isReference() {
        return reference;
    }

    public void setReference(boolean reference) {
        this.reference = reference;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
