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
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a Type (distance, temperature, ...). It had many unity.
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 12/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 03
 */
public class Type {

    private String name;
    private List<Unit> coefficientList;
    private System system;

    /**
     * Get the system related to this type
     *
     * @return The system related
     */
    public System getSystem() {
        return system;
    }

    /**
     * Set the system related to this type
     *
     * @param system the system to set
     */
    public void setSystem(System system) {
        this.system = system;
    }

    /**
     * Get the name of this type
     *
     * @return The name of this type
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this type
     *
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list of coefficient
     *
     * @return the list of coefficient
     */
    public List<Unit> getCoefficientList() {
        return coefficientList;
    }

    /**
     * Set the list of coefficient
     *
     * @param coefficientList List to set
     */
    public void setCoefficientList(List<Unit> coefficientList) {
        boolean containsZero = false;
        for (Unit u : coefficientList) {
            if (u.getCoefficient() == BigDecimal.ZERO) {
                containsZero = true;
            }
        }
        if (containsZero) {
            this.coefficientList = coefficientList;
        }
    }

    /**
     * Constructor of type
     *
     * @param name Name of type to create
     * @param refName Name of reference unit
     */
    
    public Type(String name, String refName) {
        this.name = name;
        this.coefficientList = new ArrayList();
        Unit unit = new Unit(refName, BigDecimal.ONE, true);
        this.coefficientList.add(unit);
        unit.setType(this);
        this.system = null;
    }

    /**
     * This methode add new unity with coefficient
     *
     * @param name Name of new Unity to add
     * @param coefficient Coefficient of new unity to add
     * @return True if new unity is correctly added, else False.
     */
    public boolean addCoef(String name, BigDecimal coefficient) {
        if (name != null && !name.equals("") && !this.existInList(name) && coefficient != BigDecimal.ZERO && this.coefficientList != null) {
            Unit unit = new Unit(name, coefficient, false);
            this.coefficientList.add(unit);
            unit.setType(this);
            return true;
        }
        return false;
    }

    /**
     * This method add new unity with coefficient and gap
     *
     * @param name Name of new unity
     * @param coefficient Coefficient of new unity
     * @param gap Gap of new unity
     * @return True if new unity is correctly added, else False.
     */
    public boolean addCoefDecalage(String name, BigDecimal coefficient, BigDecimal gap) {
        if (name != null && !name.equals("") && !this.existInList(name) && coefficient != BigDecimal.ZERO && this.coefficientList != null) {
            Unit unit = new Unit(name, coefficient, gap, false);
            this.coefficientList.add(unit);
            unit.setType(this);
            return true;
        }
        return false;
    }

    /**
     * This method modify the coefficient
     *
     * @param name Name of unity who contain the coefficient to modify
     * @param coefficient New coefficient to set
     * @return True if the coefficient is correctly modify, else False.
     */
    public boolean modifyCoef(String name, BigDecimal coefficient) {
        if (coefficient != BigDecimal.ZERO) {
            for (Unit u : coefficientList) {
                if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                    u.setCoefficient(coefficient);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method modify the gap
     *
     * @param name Name of unity who contain the gap to modify
     * @param gap New gap to set
     * @return
     */
    public boolean modifyGap(String name, BigDecimal gap) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                u.setGap(gap);
                return true;
            }
        }
        return false;
    }

    /**
     * This method delete a coefficient in the list
     *
     * @param name Name of coefficient to delete
     * @return True is the coefficient is correctly delete, else False
     */
    public boolean removeCoef(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                coefficientList.remove(u);
                u.setType(null);
                return true;
            }
        }
        return false;
    }

    /**
     * This method return the unity who correspond to the name in parameter
     *
     * @param name Name of research unity
     * @return the unit research if it's find, else, null
     */
    public Unit isInList(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                return u;
            }
        }
        return null;
    }

    /**
     * This method check if the unity is contain in list
     *
     * @param name Name of unity research
     * @return True if it's find, else False
     */
    public boolean existInList(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method get the reference's unity
     *
     * @return the reference's unity of this type. Null if it doesn't exist.
     */
    public Unit getReference() {
        for (Unit u : coefficientList) {
            if (u.isReference()) {
                return u;
            }
        }
        return null;
    }
    
    /**
     * This method get the coefficient
     *
     * @param name Name of the search coefficient
     * @return the Coefficient search. Null if it doesn't exist.
     */
    public BigDecimal getCoefficient(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                return u.getCoefficient();
            }
        }
        return null;
    }

    /**
     * This method get the gap
     *
     * @param name Name of the search gap
     * @return the gap search. Null if it doesn't exist.
     */
    public BigDecimal getGap(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().toUpperCase().equals(name.toUpperCase())) {
                return u.getGap();
            }
        }
        return null;
    }
}
