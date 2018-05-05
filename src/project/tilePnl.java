/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
class tilePnl extends JPanel{
    private Tiles t ;
    
    public tilePnl(Tiles tiles){
        t = tiles;
    }
    @Override 
    public void paint(Graphics g){
        super.paint(g);
        t.draw(g);
    }
}// class tilePnl
