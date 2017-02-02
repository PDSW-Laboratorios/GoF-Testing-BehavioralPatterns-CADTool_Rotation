/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import eci.pdsw.draw.controller.Controller;
import eci.pdsw.draw.model.ElementType;
import eci.pdsw.draw.model.Shape;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class TransformationsTest {
    
    public TransformationsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void duplicateTest(){
        Controller guictrl=new Controller();        
        guictrl.setSelectedElementType(ElementType.Line);
        guictrl.addShapeFromScreenPoints(new java.awt.Point(10,10),new java.awt.Point(100, 100));
        guictrl.addShapeFromScreenPoints(new java.awt.Point(20,20),new java.awt.Point(120, 120));
        
        guictrl.duplicateShapes();
        
        
        assertEquals("duplicateShapes in not duplicating the amount of shapes",guictrl.getShapes().size(), 4);
        
        List<Shape> shapes=guictrl.getShapes();
        
        
        for (Shape si:shapes){
            int refcount=0;
            for (Shape sj:shapes){
                if (si==sj) refcount++;
            }
            if (refcount>1){
                fail("duplicateShapes method is generating duplicated references");                        
            }
        }
        
    }



    
}
