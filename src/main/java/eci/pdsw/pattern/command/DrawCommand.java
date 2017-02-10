/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.pattern.command;

import eci.pdsw.draw.controller.IController;
import eci.pdsw.draw.model.Shape;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author skinman95
 */
public class DrawCommand implements Command {

    private final IController c;
    private final Point start;
    private final Point end;
    private Shape s;
    private Integer index;
    
    public DrawCommand(IController c, Point startDrag, Point endDrag) {
        this.c = c;
        this.start = new Point(startDrag);
        this.end = new Point(endDrag);
    }
    
    @Override
    public void execute() {
        if (s == null) {
            c.addShapeFromScreenPoints(start, end);
            List<Shape> shapes = c.getShapes();
            index = shapes.size()-1;
            s = shapes.get(index);
        } else {
            c.addShape(index, s);
        }
    }

    @Override
    public void undo() {
        c.deleteShape(s);
    }
    
}
