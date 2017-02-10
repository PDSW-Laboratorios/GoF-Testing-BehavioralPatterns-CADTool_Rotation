/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.draw.controller;

import eci.pdsw.pattern.command.Command;
import eci.pdsw.draw.gui.shapes.Renderer;
import eci.pdsw.draw.model.ElementType;
import eci.pdsw.draw.model.ShapeFactory;
import eci.pdsw.draw.model.Point;
import eci.pdsw.draw.model.Shape;
import eci.pdsw.pattern.command.RotateCommand;
import eci.pdsw.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author fchaves
 */
public class Controller implements IController {
    private ElementType selectedElement = ElementType.Line;
    
    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final List<Shape> shapes = new ArrayList<>();
    
    private List<Observer> observers = new ArrayList<>();
        
    private Renderer renderer;
    
    private Stack<Command> undos;
    private Stack<Command> redos;
    
    public Controller() {
        undos = new Stack<Command>();
        redos = new Stack<Command>();
    }
    
    @Override
    public void addShapeFromScreenPoints(java.awt.Point p1,java.awt.Point p2) {
        Point mp1 = Point.newPoint(new Float(p1.x), new Float(p1.y));
        Point mp2 = Point.newPoint(new Float(p2.x), new Float(p2.y));
                
        ElementType actualElementType = getSelectedElementType();
    	setSelectedElementType(actualElementType);
        addShape(mp1, mp2);
    }

    
     /**
     * Duplica todas las figuras, y las ubica en una nueva posicion.
     * @pre la coleccion 'shapes' no tiene referencias duplicadas
     * @pos la coleccion 'shapes' contiene el doble de figuras
     * @pos la coleccion 'shapes' no tiene referencias duplicadas
     */
    @Override
    public void duplicateShapes(){
        List<Point> newShapesFirstPoints=new LinkedList<>();
        List<Point> newShapesSecondPoints=new LinkedList<>();
        
        int displacementDelta=10+new Random(System.currentTimeMillis()).nextInt(50);
        
        for (Shape s:shapes){
            newShapesFirstPoints.add(new Point(s.getPoint1().getX(),s.getPoint1().getY()+displacementDelta));
            newShapesSecondPoints.add(new Point(s.getPoint2().getX(),s.getPoint2().getY()+displacementDelta));
        }
        Iterator<Point> it1=newShapesFirstPoints.iterator();
        Iterator<Point> it2=newShapesSecondPoints.iterator();
        
        while (it1.hasNext() && it2.hasNext()){
            addShape(it1.next(), it2.next());
        }
    }
  
    @Override
    public void addShape(Point p1,Point p2) {
        shapes.add(shapeFactory.createShape(selectedElement, p1, p2));
        notifyObservers();
    }
    
    @Override
    public void undo() {
    	if (! undos.empty()) {
            Command a = undos.pop();
            a.undo();
            redos.push(a);
            notifyObservers();
        }
    }

    @Override
    public void redo() {
    	if (! redos.empty()) {
            Command a = redos.pop();
            a.execute();
            undos.push(a);
            notifyObservers();
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
        
        //notificar a la capa de presentación
        notifyObservers();
    }
    
    @Override
    public void deleteShape(Shape s) {
        shapes.remove(s);
        
        //notificar a la capa de presentación
        notifyObservers();
    }
    
    /**
     * Agrega una accion a la pila de retroceso
     * @param a accion realizada
     */
    public void notifyAction(Command a) {
        if (a != null) {
            undos.push(a);
            redos.clear();
        }
    }
    
    /**
     * Rota la figura correspondiente a la posicion 'index' un angulo
     * de 90 grados a la derecha, usando como eje de rotación la esquina
     * inferior izquierda del rectángulo que contenga a la figura.
     * @param index la posicion de la figura en el conjunto de figuras
     * del controlador
     * @throws eci.pdsw.draw.controller.ControllerException
     */
    @Override
    public void rotateSelectedShape(Integer index) throws ControllerException {
        if (index < 0 || index >= shapes.size()) {
            throw new ControllerException("Indice invalido");
        }
        
        Shape s = shapes.get(index);
        
        Point p1 = s.getPoint1();
        Point p2 = s.getPoint2();
        
        double pivotx = Math.min(p1.getX(), p2.getX());
        double pivoty = Math.min(p1.getY(), p2.getY());
        
        double dx = p1.getX() - pivotx;
        double dy = p1.getY() - pivoty;
        
        double angle =  Math.atan2(dy, dx) - Math.PI/2.0;
        double r = Math.sqrt(dx*dx + dy*dy);
        
        p1.setX(new Float(r * Math.cos(angle) + pivotx));
        p1.setY(new Float(r * Math.sin(angle) + pivoty));
        
        /*  -------  */
        
        dx = p2.getX() - pivotx;
        dy = p2.getY() - pivoty;
        
        angle =  Math.atan2(dy, dx) - Math.PI/2.0;
        r = Math.sqrt(dx*dx + dy*dy);
        
        p2.setX(new Float(r * Math.cos(angle) + pivotx));
        p2.setY(new Float(r * Math.sin(angle) + pivoty));
        
        s.setPoint1(p1);
        s.setPoint2(p2);
        
        //notificar a la capa de presentación
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
