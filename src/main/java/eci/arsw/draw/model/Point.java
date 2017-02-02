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
public class Point {
    private Integer x;
    private Integer y;
    
    private Point(Integer x,Integer y) {
        this.x = x;
        this.y = y;
    }
    
    static public Point newPoint(Integer x,Integer y) {
        return new Point(x,y);
    }
    
    public Integer getX() {
        return x;
    }
    
    public Integer getY() {
        return y;
    }
}
