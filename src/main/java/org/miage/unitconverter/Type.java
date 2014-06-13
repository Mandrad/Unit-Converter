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
import java.util.ArrayList;
import java.util.List;

public class Type {
    // Cette classe représente un type (distance, puissance, ...). Elle comporte différente unité.
    private String name;
    private List<Unit> coefficientList;
    private System system;

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getCoefficientList() {
        return coefficientList;
    }

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

    public Type(String name, String refName) {
        this.name = name;
        this.coefficientList = new ArrayList();
        Unit unit = new Unit(refName, BigDecimal.ONE, true);
        this.coefficientList.add(unit);
        unit.setType(this);
        this.system = null;
    }

    // Cette fonction ajoute une nouvelle unité avec un coefficient
    public boolean addCoef(String name, BigDecimal coefficient) {
        if (name != null && !name.equals("") && !this.existInList(name) && coefficient != BigDecimal.ZERO) {
            if (this.coefficientList != null) {
                Unit unit = new Unit(name, coefficient, false);
                this.coefficientList.add(unit);
                unit.setType(this);
                return true;
            }
        }
        return false;
    }

    // Cette fonction ajoute une nouvelle unité avec un coefficient et un décalage
    public boolean addCoefDecalage(String name, BigDecimal coefficient, BigDecimal gap) {
        if (name != null && !name.equals("") && !this.existInList(name) && coefficient != BigDecimal.ZERO) {
            if (this.coefficientList != null) {
                Unit unit = new Unit(name, coefficient, gap, false);
                this.coefficientList.add(unit);
                unit.setType(this);
                return true;
            }
        }
        return false;
    }

    // Cette fonction modifie le coefficient
    public boolean modifyCoef(String name, BigDecimal coefficient) {
        if (coefficient != BigDecimal.ZERO) {
            for (Unit u : coefficientList) {
                if (u.getName().equals(name)) {
                    u.setCoefficient(coefficient);
                    return true;
                }
            }
        }
        return false;
    }

    // Cette fonction modifie le décalage
    public boolean modifyDecalage(String name, BigDecimal gap) {
        for (Unit u : coefficientList) {
            if (u.getName().equals(name)) {
                u.setGap(gap);
                return true;
            }
        }
        return false;
    }

    //Cette fonction supprime une unité dans la liste
    public boolean removeCoef(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().equals(name)) {
                coefficientList.remove(u);
                u.setType(null);
                return true;
            }
        }
        return false;
    }

    // Cette fonction renvoi l'unité qui correspond à la chaine de caractère passée en paramètre
    public Unit isInList(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().equals(name.toUpperCase())) {
                return u;
            }
        }
        return null;
    }

    // Cette fonction renvoi "true" si l'unité correpondant à la string en paramètre est dans la liste
    public boolean existInList(String name) {
        for (Unit u : coefficientList) {
            if (u.getName().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public Unit getReference() {
        for (Unit u : coefficientList) {
            if (u.isReference()) {
                return u;
            }
        }
        return null;
    }
}
