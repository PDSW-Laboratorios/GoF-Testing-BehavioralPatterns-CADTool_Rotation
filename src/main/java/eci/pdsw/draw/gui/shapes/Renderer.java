/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.draw.gui.shapes;

import eci.pdsw.draw.gui.shapes.empty.EmptyEllipseRenderer;
import eci.pdsw.draw.gui.shapes.empty.EmptyLineRenderer;
import eci.pdsw.draw.gui.shapes.empty.EmptyRectangleRenderer;

/**
 *
 * @author fchaves
 */
public interface Renderer {
    public LineRenderer createLineRenderer();
    public RectangleRenderer createRectangleRenderer();
    public EllipseRenderer createEllipseRenderer();
}
