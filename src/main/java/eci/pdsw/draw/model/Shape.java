/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.draw.model;

import java.util.Objects;

/**
 *
 * @author fchaves
 */
public abstract class Shape {
    private Point p1;

    private Point p2; 

    protected Shape(Point p1,Point p2) {
       this.p1 = p1;
       this.p2 = p2;
    }
    
    abstract public ElementType getElementType();
    
    public Point getPoint1() {
        return p1;
    }
    
    abstract public Shape cloneShape();    
    
    public Point getPoint2() {
        return p2;
    }
    
    public void setPoint1(Point p1) {
        this.p1 = p1;
    }

    public void setPoint2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Compara si dos objetos tienen la misma referencia para considerarlos 
     * iguales
     * @param o objeto a comparar
     * @return tienen la misma referencia (son el mismo objeto)
     */
    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.p1);
        hash = 41 * hash + Objects.hashCode(this.p2);
        return hash;
    }
}
