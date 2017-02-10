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
     * Prueba Clase de Equivalencia: Rota linea vertical
     * Deberia rotar una figura 90 grados a la derecha cuando la linea es vertical
     * @throws java.lang.Exception
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
     * Prueba Clase de Equivalencia: Linea Recta Inclinada Con Pendiente Positiva
     * Deberia rotar una figura 90 grados a la derecha con pendiente positiva
     * @throws java.lang.Exception
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
     * Prueba Clase de Equivalencia: Linea Recta Inclinada Con Pendiente Negativa
     * Deberia rotar una figura 90 grados a la derecha con pendiente negativa
     * @throws java.lang.Exception
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
     * Prueba Clase de Equivalencia: Linea Recta Horizontal
     * Deberia rotar una figura 90 grados a la derecha cuando es una recta horizontal
     * @throws java.lang.Exception
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
     * Prueba Clase de Equivalencia: Indice invalido
     * Deberia lanzar excepcion si se da un indice invalido de las figuras
     * @throws java.lang.Exception
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
