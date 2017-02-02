/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.draw.gui.shapes;

import eci.arsw.draw.model.Line;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public interface LineRenderer {
    public void draw(Graphics2D g,Line line);
}
