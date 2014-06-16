/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miage.unitconverter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a system who contains many Type (like Imperial, Metric,
 * ...)
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 */
public class System {

    private String name;
    private List<Type> typeList;

    /**
     * This is the only constructor of this class
     *
     * @param name Represent the name of each System
     */
    public System(String name) {
        this.name = name;
        this.typeList = new ArrayList<>();
    }

    /**
     * This method add a type to the system
     *
     * @param type Type of unit (temperature, distance, ...)
     */
    public void addType(Type type) {
        if (typeList != null) {
            typeList.add(type);
            type.setSystem(this);
        }
    }

    /**
     * This method delete a type to the System
     *
     * @param name Name of type to delete
     * @return True if type is deleted, else False.
     */
    public boolean removeType(String name) {
        for (Type t : typeList) {
            if (t.getName().equals(name)) {
                typeList.remove(t);
                t.setSystem(null);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the value of name
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name Value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list who contain the type
     *
     * @return the list
     */
    public List<Type> getTypeList() {
        return typeList;
    }

    /**
     * Set the list who contain the type
     *
     * @param typeList List to set
     */
    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

}
