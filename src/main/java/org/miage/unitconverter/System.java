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

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a system who contains many Type (like Imperial, Metric,
 * ...)
 *
 * @author Sebastien DUBOIS and Louis MORIN
 * @version 1.0
 * 
 * Date of last change : 18/06/2014
 * Author of last change : Louis MORIN
 * Revision number : 08
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
