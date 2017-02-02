/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.draw.gui.shapes.fill;

import eci.pdsw.draw.gui.shapes.RectangleRenderer;
import eci.pdsw.draw.model.Rectangle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public class FillRectangleRenderer implements RectangleRenderer {

    @Override
    public void draw(Graphics2D g2, Rectangle rectangle) {

        Integer width = Math.abs(rectangle.getPoint2().getX() - rectangle.getPoint1().getX());
        Integer height = Math.abs(rectangle.getPoint2().getY() - rectangle.getPoint1().getY());
        
        g2.setPaint(Color.blue);
        g2.setStroke(new BasicStroke(FillRenderer.STROKE_WIDTH));
        g2.drawRect(rectangle.getPoint1().getX(),rectangle.getPoint1().getY(), width, height);
        g2.setPaint(new Color(0f,0f,1f,.5f ));
        g2.fillRect(rectangle.getPoint1().getX(),rectangle.getPoint1().getY(), width, height);
    }
    
}
