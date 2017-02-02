/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.gui.shapes.fill;

import eci.arsw.draw.gui.shapes.Renderer;
import eci.arsw.draw.gui.shapes.LineRenderer;
import eci.arsw.draw.gui.shapes.RectangleRenderer;
import eci.arsw.draw.gui.shapes.EllipseRenderer;

/**
 *
 * @author fchaves
 */
public class FillRenderer implements Renderer {
    
	static final int STROKE_WIDTH = 1;
	
    @Override
    public LineRenderer createLineRenderer() {
        return new FillLineRenderer();
    }

    
    @Override
    public RectangleRenderer createRectangleRenderer() {
        return new FillRectangleRenderer();
    }

    @Override
    public EllipseRenderer createEllipseRenderer() {
        return new FillEllipseRenderer();
    }

}
