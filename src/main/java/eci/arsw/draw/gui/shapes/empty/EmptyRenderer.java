/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.gui.shapes.empty;

import eci.arsw.draw.gui.shapes.Renderer;
import eci.arsw.draw.gui.shapes.LineRenderer;
import eci.arsw.draw.gui.shapes.RectangleRenderer;
import eci.arsw.draw.gui.shapes.EllipseRenderer;

/**
 *
 * @author fchaves
 */
public class EmptyRenderer implements Renderer {
    
    @Override
    public LineRenderer createLineRenderer() {
        return new EmptyLineRenderer();
    }

    
    @Override
    public RectangleRenderer createRectangleRenderer() {
        return new EmptyRectangleRenderer();
    }

    @Override
    public EllipseRenderer createEllipseRenderer() {
        return new EmptyEllipseRenderer();
    }

}
