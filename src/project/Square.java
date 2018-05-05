/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
class Square {
    private int x = 0;
    private int y = 0;
    private int tileNum = 2;
    private Color c = Color.BLACK; 
    
    public Square (int x, int y, Color c, int t){
        this.x = x;
        this.y = y;
        this.c = c;
        this.tileNum = t;
    } //Square
    
    public int getX(){return this.x;}
    public int getY(){return this.y;}


    void draw(Graphics g){
        g.setColor(c);
        g.drawRoundRect(this.getX(), this.getY(), tileDim.SIZE, tileDim.SIZE, 1, 1);
        g.setFont(g.getFont().deriveFont(28.0f));
        g.drawString(Integer.toString(tileNum), (this.x+tileDim.LBL_x) - ((int)(Math.log10(tileNum)+1)*4), this.y+tileDim.LBL_Y);
    } // draw
}// class Square  
