/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.gui.shapes.empty;

import eci.arsw.draw.gui.shapes.EllipseRenderer;
import eci.arsw.draw.model.Ellipse;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public class EmptyEllipseRenderer implements EllipseRenderer {

    @Override
    public void draw(Graphics2D g2, Ellipse ellipse) {
        g2.setPaint(Color.red);

        Integer width = Math.abs(ellipse.getPoint2().getX() - ellipse.getPoint1().getX());
        Integer height = Math.abs(ellipse.getPoint2().getY() - ellipse.getPoint1().getY());
        g2.drawOval(ellipse.getPoint1().getX(),ellipse.getPoint1().getY(), width, height);
    }
    
}
