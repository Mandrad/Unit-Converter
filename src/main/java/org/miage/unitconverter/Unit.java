/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.miage.unitconverter;

import java.math.BigDecimal;

/**
 * This class represent a unity (meter, kilometer, celcius, ...).
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 */
public class Unit {
    
    private String name;
    private BigDecimal coefficient;
    private BigDecimal gap;
    private boolean reference;
    private Type type;

    /**
     * Creator of unity (without gap (zero by default)
     * @param name Name of unity
     * @param coef Coefficient of unity
     * @param reference True if this unity is the reference, else False
     */
    public Unit(String name, BigDecimal coef, Boolean reference) {
        this.name = name.toUpperCase();
        this.coefficient = coef;
        this.gap = BigDecimal.ZERO;
        this.reference = reference;
        this.type = null;
    }
    
    /**
     * Creator of unity with gap
     * @param name Name of unity
     * @param coef Coefficient of unity
     * @param gap Gap of unity
     * @param reference True if this unity is the reference, else False
     */
    public Unit(String name, BigDecimal coef, BigDecimal gap, Boolean reference) {
        this.name = name.toUpperCase();
        this.coefficient = coef;
        this.gap = gap;
        this.reference = reference;
        this.type = null;
    }

    /**
     * Get the name of this unity
     * @return name of this unity
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this unity
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    /**
     * Get the coefficient of this unity
     * @return The coefficient of this unity
     */
    public BigDecimal getCoefficient() {
        return coefficient;
    }

    /**
     * Set new coefficient to this unity
     * @param coefficient Coefficient to set
     */
    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Get the gap
     * @return the gap
     */
    public BigDecimal getGap() {
        return gap;
    }

    /**
     * Set new gap to this unity
     * @param gap Gap to set
     */
    public void setGap(BigDecimal gap) {
        this.gap = gap;
    }
    
    /**
     * Check if this unity is the reference
     * @return true if it's the reference, else False
     */
    public boolean isReference() {
        return reference;
    }

    /**
     * Set new reference
     * @param reference Reference to set
     */
    public void setReference(boolean reference) {
        this.reference = reference;
    }

    /**
     * Get the type of this unity
     * @return The type of this unity
     */
    public Type getType() {
        return type;
    }

    /**
     * Set the type of this unity
     * @param type Type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
}
