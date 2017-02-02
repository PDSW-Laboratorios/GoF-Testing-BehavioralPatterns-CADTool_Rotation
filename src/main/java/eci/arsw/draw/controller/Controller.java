/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.controller;

import eci.arsw.pattern.command.Command;
import eci.arsw.draw.gui.shapes.Renderer;
import eci.arsw.draw.model.ElementType;
import eci.arsw.draw.model.ShapeFactory;
import eci.arsw.draw.model.Point;
import eci.arsw.draw.model.Shape;
import eci.arsw.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author fchaves
 */
public class Controller implements IController {
    private ElementType selectedElement = ElementType.Line;
    
    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final List<Shape> shapes = new ArrayList<>();
    
    private List<Observer> observers = new ArrayList<>();
    
    private Stack<Command> undoCommands = new Stack<>();
    private Stack<Command> redoCommands = new Stack<>();
    
    private Renderer renderer;
    
    public Controller() {
    }
    
    @Override
    public void commandAddShape(java.awt.Point p1,java.awt.Point p2) {
        Point mp1 = Point.newPoint(p1.x, p1.y);
        Point mp2 = Point.newPoint(p2.x, p2.y);
                
        ElementType actualElementType = getSelectedElementType();
    	setSelectedElementType(actualElementType);
        addShape(mp1, mp2);                 

    }
    
    @Override
    public void commandDeleteShape(int index) {
        deleteShape(index);
       
    }

    
    @Override
    public void addShape(Point p1,Point p2) {
        shapes.add(shapeFactory.createShape(selectedElement, p1, p2));
        notifyObservers();
    }
    
    @Override
    public void undo() {
    	if (undoCommands.size() > 0) {
    		Command command = undoCommands.pop();
    		redoCommands.push(command);
    		command.undo();
    	}	
    }

    @Override
    public void redo() {
    	if (redoCommands.size() > 0) {
    		Command command = redoCommands.pop();
    		undoCommands.push(command);
    		command.execute();
    	}	
    }

    @Override
    public void addShape(Integer index, Shape shape) {
        shapes.add(index,shape);
        notifyObservers();
    }   
    
    @Override
    public void deleteShape(Integer index) {
        int idx = index;
        shapes.remove(idx);
        notifyObservers();
    }
    
    @Override
    public void setRenderer(Renderer renderer) {
    	this.renderer = renderer;
    	notifyObservers();
    }
    
    @Override
    public Renderer getRenderer() {
    	return this.renderer;
    }
    
    @Override
    public List<Shape> getShapes() {
        return shapes;
    }
    
    @Override
    public void setSelectedElementType(ElementType elementType) {
        this.selectedElement = elementType;
    }  
    
    @Override
    public ElementType getSelectedElementType() {
        return this.selectedElement;
    }

    @Override
    public void addObserver(Observer o) {
            observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
            observers.remove(o);
    }

    @Override
    public void notifyObservers() {
            for(Observer o : observers) {
                    o.update();
            }
    }
}
