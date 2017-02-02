/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.controller.command;

import eci.arsw.draw.controller.IController;
import eci.arsw.pattern.command.Command;
import eci.arsw.draw.model.ElementType;
import eci.arsw.draw.model.Point;


/**
 *
 * @author fchaves
 */
public class CommandAddShape implements Command {

    private IController controller;
    private Point p1;
    private Point p2;
    private ElementType elementType;
    
    public CommandAddShape(IController controller,Point p1,Point p2) {
        this.controller = controller;
        this.p1 = p1;
        this.p2 = p2;
        this.elementType = controller.getSelectedElementType();
    }
    
    @Override
    public void execute() {
    	ElementType actualElementType = controller.getSelectedElementType();
    	controller.setSelectedElementType(elementType);
        controller.addShape(p1, p2);         
        controller.setSelectedElementType(actualElementType);
    }

	@Override
	public void undo() {
		controller.deleteShape(controller.getShapes().size()-1);
	}

    
}
