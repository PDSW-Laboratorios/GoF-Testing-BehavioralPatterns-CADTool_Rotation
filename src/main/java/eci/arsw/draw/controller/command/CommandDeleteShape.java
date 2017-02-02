/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.controller.command;

import eci.arsw.draw.controller.IController;
import eci.arsw.pattern.command.Command;
import eci.arsw.draw.model.Shape;

/**
 *
 * @author fchaves
 */
public class CommandDeleteShape implements Command {

    private Shape shape;
    private Integer index;
    private IController controller;
    
    public CommandDeleteShape(IController controller,Integer index) {
        this.controller = controller;
        this.index = index;
        this.shape = controller.getShapes().get(index);
    }
    
    @Override
    public void execute() {
        this.controller.deleteShape(index);
    }

	@Override
	public void undo() {
		this.controller.addShape(index, shape);		
	}
    
}
