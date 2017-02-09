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
public class Point {
    private static final double EPSILON = 1e-8;
    
    private Float x;

    private Float y;
    
    public Point(Float x,Float y) {
        this.x = x;
        this.y = y;
    }
    
    static public Point newPoint(Float x,Float y) {
        return new Point(x,y);
    }
    
    public Float getX() {
        return x;
    }
    
    public Float getY() {
        return y;
    }
    
    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "[" + x + ", " + y +  "]";
    }
    
    @Override
    public boolean equals(Object s) {
        boolean r = true;
        
        try {
            Point p = (Point) s;
            r = r && ( Math.abs(p.getX() - this.getX()) < EPSILON );
            r = r && ( Math.abs(p.getY() - this.getY()) < EPSILON );
        } catch (ClassCastException e) {
            r = false;
        }
        
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.x);
        hash = 97 * hash + Objects.hashCode(this.y);
        return hash;
    }
    
}
