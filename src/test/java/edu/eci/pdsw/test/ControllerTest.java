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
     * Prueba Clase de Equivalencia: Rota 90 grados
     * Deberia rotar una figura 90 grados a la derecha con pivote la parte
     * inferior izquierda del rectangulo que la contiene
     * @throws java.lang.Exception
     */
    @Test
    public void testClaseEquivalenciaRota90Grados() throws Exception {
        Controller c = new Controller();
        
        c.setSelectedElementType(ElementType.Line);
        
        Point pi1 = new Point(0f, 0f);
        Point pi2 = new Point(0f, 1f);
        c.addShape(pi1, pi2);
        
        int index = c.getShapes().size()-1;
        
        c.rotateSelectedShape(index);
        
        ArrayList<Shape> l = new ArrayList(c.getShapes());
        
        Assert.assertEquals("No se roto correctamente la figura", new Point(1f,0f), l.get(index).getPoint2());
        Assert.assertEquals("No se roto correctamente la figura", new Point(0f,0f), l.get(index).getPoint1());
    }
    
    /**
     * Prueba Clase de Equivalencia: Rota de pivote
     * Deberia rotar del pivote inferior izquierdo del rectangulo que rodea la figura
     * @throws java.lang.Exception
     */
    @Test
    public void testClaseEquivalenciaRotaDePivote() throws Exception{
        Controller c = new Controller();
        
        c.setSelectedElementType(ElementType.Line);
        
        Point pi1 = new Point(1f, 0f);
        Point pi2 = new Point(0f, 1f);
        c.addShape(pi1, pi2);
        
        int index = c.getShapes().size()-1;
        
        c.rotateSelectedShape(index);
        
        ArrayList<Shape> l = new ArrayList(c.getShapes());
        
        // Pueden estar en cualquier orden los elementos pero ser correctos
        Point[] p = { new Point(1f,0f), new Point(0f,-1f) };
        int i = 0;
        Assert.assertTrue("No se roto correctamente la figura", (l.get(index).getPoint2().equals(p[i = 0]) ) 
                || (l.get(index).getPoint2().equals(p[i = 1])));
        i = (i+1) % 2;
        Assert.assertEquals("No se roto correctamente la figura", p[i] , l.get(index).getPoint1());
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
