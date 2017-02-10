/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import eci.pdsw.draw.controller.Controller;
import eci.pdsw.draw.controller.ControllerException;
import eci.pdsw.draw.model.ElementType;
import eci.pdsw.draw.model.Point;
import eci.pdsw.draw.model.Shape;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skinman95
 */
public class ControllerTest {
    
    /**
     * # CE: 1
     * Metodo: Controller.rotateSelectedShape 
     * Clase de Equivalencia: Linea recta l tal que l.getPoint1.x == l.getPoint2.x
     * Tipo: Correcta/Standard
     * Resultado: Lina recta r tal que 
     * (r.getPoint2.x == l.getPoint2.x + l.getPoint2.y - l.getPiont1.y) ^ 
     * (r.getPoint2 == l.getPoint1.y) ^ (r.getPoint1.x == l.getPoint1.x) ^ 
     * (r.getPoint1.y == l.getPoint1.y)
     */
    @Test
    public void testClaseEquivalenciaRotaLineaVertical() throws Exception {
        Controller c = new Controller();
        
        Point p1 = new Point(3f, 1f);
        Point p2 = new Point(3f, 5f);
        
        c.addShape(p1, p2);
        
        p1 = new Point(3f, 1f);
        p2 = new Point(7f, 1f);
        
        c.rotateSelectedShape(0);
        
        Assert.assertEquals("Rotacion incorrecta", p1, c.getShapes().get(0).getPoint1());
        Assert.assertEquals("Rotacion incorrecta", p2, c.getShapes().get(0).getPoint2());
    }
    
    /**
     * # CE: 2
     * Metodo: Controller.rotateSelectedShape 
     * Clase de Equivalencia: Linea recta y cualquier tipo de rectangulo l tal que 
     * ((l.getPoint2.y - l.getPoint1.y) / (l.getPoint2.x - l.getPoint1.x)) > 0
     * Tipo: Correcta/Standard
     * Resultado: Linea recta y cualquier tipo de rectangulo r tal que 
     * (r.getPoint1.x == l.getPoint1.x) ^ 
     * (r.getPoint1.y == l.getPoint1.y) ^ 
     * (r.getPoint2.x == (l.getPoint2.y - l.getPoint1.y + l.getPoint1.x)) ^ 
     * (r.getPoint2.y == (l.getPoint1.y - l.getPoint2.x + l.getPoint1.x))
     */
    @Test
    public void testClaseEquivalenciaLineaRectaInclinadaConPendientePositiva() throws Exception {
        Controller c = new Controller();
        
        Point p1 = new Point(1f, 7f);
        Point p2 = new Point(3f, 11f);
        
        c.addShape(p1, p2);
        
        p1 = new Point(1f, 7f);
        p2 = new Point(5f, 5f);
        
        c.rotateSelectedShape(0);
        
        Assert.assertEquals("Rotacion incorrecta", p1, c.getShapes().get(0).getPoint1());
        Assert.assertEquals("Rotacion incorrecta", p2, c.getShapes().get(0).getPoint2());
    }
    
    /**
     * # CE: 3
     * Metodo: Controller.rotateSelectedShape 
     * Clase de Equivalencia: Linea recta l tal que ((l.getPoint2.y - l.getPoint1.y) / (l.getPoint2.x - l.getPoint1.x)) < 0
     * Tipo: Correcta/Standard
     * Resultado: Linea recta r tal que (r.getPoint1.x == l.getPoint1.x) ^ 
     * (r.getPoint1.y == l.getPoint2.y - l.getPoint2.x - l.getPoint1.x) ^ 
     * (r.getPoint2.x == l.getPoint1.y - l.getPoint2.y + l.getPoint1.x) ^ 
     * (r.getPoint2.y == l.getPoint2.y) 
     */
    @Test
    public void testClaseEquivalenciaLineaRectaInclinadaConPendienteNegativa() throws Exception {
        Controller c = new Controller();
        
        Point p1 = new Point(1f, 8f);
        Point p2 = new Point(3f, 4f);
        
        c.addShape(p1, p2);
        
        p1 = new Point(5f, 4f);
        p2 = new Point(1f, 2f);
        
        c.rotateSelectedShape(0);
        
        Assert.assertEquals("Rotacion incorrecta", p1, c.getShapes().get(0).getPoint1());
        Assert.assertEquals("Rotacion incorrecta", p2, c.getShapes().get(0).getPoint2());
    }
    
    /**
     * # CE: 4
     * Metodo: Controller.rotateSelectedShape 
     * Clase de Equivalencia: Linea recta  l  tal que l.getPoint1.y == l.getPoint2.y
     * Tipo: Correcta/Standard
     * Resultado: Linea recta r tal que (r.getPoint1.x == l.getPoint1.x) ^ 
     * (r.getPoint1.y == l.getPoint1.y) ^ (r.getPoint2.x == l.getPoint1.x) ^ 
     * (r.getPoint2.y == l.getPoint2.y - l.getPoint2.x + l.getPoint1.x)
     */
    @Test
    public void testClaseEquivalenciaLineaRectaHorizontal() throws Exception {
        Controller c = new Controller();
        
        Point p1 = new Point(1f, 5f);
        Point p2 = new Point(6f, 5f);
        
        c.addShape(p1, p2);
        
        p1 = new Point(1f, 5f);
        p2 = new Point(1f, 0f);
        
        c.rotateSelectedShape(0);
        
        Assert.assertEquals("Rotacion incorrecta", p1, c.getShapes().get(0).getPoint1());
        Assert.assertEquals("Rotacion incorrecta", p2, c.getShapes().get(0).getPoint2());
    }
    
    /**
     * # CE: 6
     * Metodo: Controller.rotateSelectedShape 
     * Clase de Equivalencia: index < 0 V index > (shapes.getSize - 1)
     * Tipo: Error
     * Resultado: Indice en shapes inválido.
     */
    @Test(expected=ControllerException.class)
    public void testClaseEquivalenciaIndiceInvalido() throws Exception {
        Controller c = new Controller();
        c.setSelectedElementType(ElementType.Line);
        
        Point pi1 = new Point(0f, 0f);
        Point pi2 = new Point(0f, 1f);
        c.addShape(pi1, pi2);
        
        c.rotateSelectedShape(-1);
    }
}
