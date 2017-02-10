/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.pattern.command;

import eci.pdsw.draw.controller.IController;
import eci.pdsw.draw.model.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skinman95
 */
public class DuplicateCommand implements Command {

    private final IController c;
    private List<Shape> shapes;
    
    public DuplicateCommand(IController c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        List<Shape> shapesBefore = new ArrayList<Shape>();
        shapesBefore.addAll(c.getShapes());
        c.duplicateShapes();
        
        shapes = new ArrayList<Shape>(c.getShapes());
        shapes.removeAll(shapesBefore);
    }

    @Override
    public void undo() {
        c.getShapes().removeAll(shapes);
    }
    
}
