/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.pattern.command;

import eci.pdsw.draw.controller.ControllerException;
import eci.pdsw.draw.controller.IController;
import eci.pdsw.draw.model.Point;
import eci.pdsw.draw.model.Shape;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skinman95
 */
public class RotateCommand implements Command {

    private final Point p1;
    private final Point p2;
    private Shape s;
    private final Integer index;
    private final IController c;
    
    public RotateCommand(IController c, Integer index) {
        this.c = c;
        this.index = index;
        
        s = c.getShapes().get(index);
        Point p = s.getPoint1();
        this.p1 = new Point(p.getX(), p.getY());
        p = s.getPoint2();
        this.p2 = new Point(p.getX(), p.getY());
    }
    
    @Override
    public void execute() {
        try {
            s = c.getShapes().get(index);
            c.rotateSelectedShape(index);
        } catch (ControllerException ex) {
            Logger.getLogger(RotateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        s.setPoint1(new Point(p1.getX(), p1.getY()));
        s.setPoint2(new Point(p2.getX(), p2.getY()));
    }
    
}
