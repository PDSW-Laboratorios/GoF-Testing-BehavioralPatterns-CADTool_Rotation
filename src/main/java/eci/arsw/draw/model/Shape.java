/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.model;

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
    
    public Point getPoint2() {
        return p2;
    }
}
