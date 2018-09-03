package project;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;

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
