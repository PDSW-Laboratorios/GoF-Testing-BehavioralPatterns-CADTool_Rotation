/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.gui.shapes.fill;

import eci.arsw.draw.gui.shapes.EllipseRenderer;
import eci.arsw.draw.model.Ellipse;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public class FillEllipseRenderer implements EllipseRenderer {

    @Override
    public void draw(Graphics2D g2, Ellipse ellipse) {
        Integer width = Math.abs(ellipse.getPoint2().getX() - ellipse.getPoint1().getX());
        Integer height = Math.abs(ellipse.getPoint2().getY() - ellipse.getPoint1().getY());
        g2.setPaint(Color.red);
        g2.setStroke(new BasicStroke(FillRenderer.STROKE_WIDTH));
        g2.drawOval(ellipse.getPoint1().getX(),ellipse.getPoint1().getY(), width, height);        
        g2.setPaint(new Color(1f,0f,0f,.5f ));
        g2.fillOval(ellipse.getPoint1().getX(),ellipse.getPoint1().getY(), width, height);
    }
    
}
