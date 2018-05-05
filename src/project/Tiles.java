/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
class Tiles {
    private Random random = new Random();
    private ArrayList TilesArray = new ArrayList();
    private swapDirection swapDir = swapDirection.RIGHT;
    private int score = 0;
    private int Hscore = 0;
    private boolean validMove = true;
    private boolean arrayCompare = true;
    protected int[][] TilesPosition = new int[][]{
  { 0, 0, 0 },
  { 0, 0, 0 },
  { 0, 0, 0 }};
    
    public Tiles (){
        // Generate 2 randomly postioned tiles.     
        generateTile(true);
        generateTile(true);
    } // tile
    
    protected void move(){
    int [][] oldTilesPosition = new int[3][3];
    arrayOp(TilesPosition, oldTilesPosition, "Copy");
        int row = 0, col = 0;
        switch(this.swapDir){

            case RIGHT:
                col = 2;
                    for( row=0 ; row<3 ; row++){
                        // Check if 1st tile in column is zero
                        if(TilesPosition[row][col] == 0){
                            if(TilesPosition[row][col-1] == 0){
                                TilesPosition[row][col] = TilesPosition[row][col-2];
                                TilesPosition[row][col-2] = 0;
                                
                            }else{
                                if(TilesPosition[row][col-1] == TilesPosition[row][col-2]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col-1]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col-1] = 0;
                                    TilesPosition[row][col-2] = 0;
                                    
                                }else{
                                    TilesPosition[row][col] = TilesPosition[row][col-1];
                                    TilesPosition[row][col-1] = TilesPosition[row][col-2];
                                    TilesPosition[row][col-2] = 0;
                                    
                                }
                            }
                        }
                        // Check if the 2nd tile in column is zero
                        else if(TilesPosition[row][col-1] == 0){
                                // Check if the 2nd & 3rd tiles are equal
                                if(TilesPosition[row][col] == TilesPosition[row][col-2]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col-2]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col-2] = 0;
                                    
                                }else{
                                    TilesPosition[row][col-1] = TilesPosition[row][col-2];
                                    TilesPosition[row][col-2] = 0;
                                    
                                }
                                // check if the 1st & 2nd tile are equal
                            }else if(TilesPosition[row][col-1] != 0 && TilesPosition[row][col] == TilesPosition[row][col-1]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col-1]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col-1] = TilesPosition[row][col-2];
                                    TilesPosition[row][col-2] = 0;
                                    
                                }else if(TilesPosition[row][col-1] == TilesPosition[row][col-2]){
                                        TilesPosition[row][col-1] = merge(TilesPosition[row][col-2]);
                                        score += TilesPosition[row][col-1];
                                        TilesPosition[row][col-2] = 0;
                                           
                        }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row][col-1]){
                            TilesPosition[row][col] = merge(TilesPosition[row][col-1]);
                            score += TilesPosition[row][col];
                            TilesPosition[row][col-1] = 0;
                        }
                    }
                break;
                
            case LEFT:
                col = 0;
                    for(row=0 ; row<3 ; row++){
                        // Check if 1st tile in column is zero
                        if(TilesPosition[row][col] == 0){
                            if(TilesPosition[row][col+1] == 0){
                                TilesPosition[row][col] = TilesPosition[row][col+2];
                                TilesPosition[row][col+2] = 0;
                                
                            }else{
                                if(TilesPosition[row][col+1] == TilesPosition[row][col+2]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col+1]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col+1] = 0;
                                    TilesPosition[row][col+2] = 0;
                                    
                                }else{
                                    TilesPosition[row][col] = TilesPosition[row][col+1];
                                    TilesPosition[row][col+1] = TilesPosition[row][col+2];
                                    TilesPosition[row][col+2] = 0;
                                    
                                }
                            }
                        }
                        // Check if the 2nd tile in column is zero
                        else if(TilesPosition[row][col+1] == 0){
                                // Check if the 2nd & 3rd tiles are equal
                                if(TilesPosition[row][col] == TilesPosition[row][col+2]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col+2]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col+2] = 0;
                                    
                                }else{
                                    TilesPosition[row][col+1] = TilesPosition[row][col+2];
                                    TilesPosition[row][col+2] = 0;
                                    
                                }
                                // check if the 1st & 2nd tile are equal
                            }else if(TilesPosition[row][col+1] != 0 && TilesPosition[row][col] == TilesPosition[row][col+1]){
                                    TilesPosition[row][col] = merge(TilesPosition[row][col+1]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row][col+1] = TilesPosition[row][col+2];
                                    TilesPosition[row][col+2] = 0;
                                    
                                }else if(TilesPosition[row][col+1] == TilesPosition[row][col+2]){
                                        TilesPosition[row][col+1] = merge(TilesPosition[row][col+2]);
                                        score += TilesPosition[row][col+1];
                                        TilesPosition[row][col+2] = 0;
                                
                        }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row][col+1]){
                            TilesPosition[row][col] = merge(TilesPosition[row][col+1]);
                            score += TilesPosition[row][col];
                            TilesPosition[row][col+1] = 0;
                        }
                    }
                break;
                
            case DOWN:
                row = 2;
                    for(col=0 ; col<3 ; col++){
                        // Check if 1st tile in column is zero
                        if(TilesPosition[row][col] == 0){
                            if(TilesPosition[row-1][col] == 0){
                                TilesPosition[row][col] = TilesPosition[row-2][col];
                                TilesPosition[row-2][col] = 0;
                                
                            }else{
                                if(TilesPosition[row-1][col] == TilesPosition[row-2][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row-1][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row-1][col] = 0;
                                    TilesPosition[row-2][col] = 0;
                                    
                                }else{
                                    TilesPosition[row][col] = TilesPosition[row-1][col];
                                    TilesPosition[row-1][col] = TilesPosition[row-2][col];
                                    TilesPosition[row-2][col] = 0;
                                    
                                }
                            }
                        }
                        // Check if the 2nd tile in column is zero
                        else if(TilesPosition[row-1][col] == 0){
                                // Check if the 2nd & 3rd tiles are equal
                                if(TilesPosition[row][col] == TilesPosition[row-2][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row-2][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row-2][col] = 0;
                                    
                                }else{
                                    TilesPosition[row-1][col] = TilesPosition[row-2][col];
                                    TilesPosition[row-2][col] = 0;
                                    
                                }
                                // check if the 1st & 2nd tile are equal
                            }else if(TilesPosition[row-1][col] != 0 && TilesPosition[row][col] == TilesPosition[row-1][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row-1][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row-1][col] = TilesPosition[row-2][col];
                                    TilesPosition[row-2][col] = 0;
                                    
                                }else if(TilesPosition[row-1][col] == TilesPosition[row-2][col]){
                                        TilesPosition[row-1][col] = merge(TilesPosition[row-2][col]);
                                        score += TilesPosition[row-1][col];
                                        TilesPosition[row-2][col] = 0;
                                        
                                }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row-1][col]){
                                        TilesPosition[row][col] = merge(TilesPosition[row-1][col]);
                                        score += TilesPosition[row][col];
                                        TilesPosition[row-1][col] = 0;
                        }
                    }
                break;
                
            case UP:
                row = 0;
                    for(col=0 ; col<3 ; col++){
                        // Check if 1st tile in column is zero
                        if(TilesPosition[row][col] == 0){
                            if(TilesPosition[row+1][col] == 0){
                                TilesPosition[row][col] = TilesPosition[row+2][col];
                                TilesPosition[row+2][col] = 0;
                                
                            }else{
                                if(TilesPosition[row+1][col] == TilesPosition[row+2][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row+1][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row+1][col] = 0;
                                    TilesPosition[row+2][col] = 0;
                                    
                                }else{
                                    TilesPosition[row][col] = TilesPosition[row+1][col];
                                    TilesPosition[row+1][col] = TilesPosition[row+2][col];
                                    TilesPosition[row+2][col] = 0;
                                    
                                }
                            }
                        }
                        // Check if the 2nd tile in column is zero
                        else if(TilesPosition[row+1][col] == 0){
                                // Check if the 2nd & 3rd tiles are equal
                                if(TilesPosition[row][col] == TilesPosition[row+2][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row+2][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row+2][col] = 0;
                                    
                                }else{
                                    TilesPosition[row+1][col] = TilesPosition[row+2][col];
                                    TilesPosition[row+2][col] = 0;
                                    
                                }
                                // check if the 1st & 2nd tile are equal
                            }else if(TilesPosition[row][col] == TilesPosition[row+1][col]){
                                    TilesPosition[row][col] = merge(TilesPosition[row+1][col]);
                                    score += TilesPosition[row][col];
                                    TilesPosition[row+1][col] = TilesPosition[row+2][col];
                                    TilesPosition[row+2][col] = 0;
                                    
                                }else if(TilesPosition[row+1][col] == TilesPosition[row+2][col]){
                                        TilesPosition[row+1][col] = merge(TilesPosition[row+2][col]);
                                        score += TilesPosition[row+1][col];
                                        TilesPosition[row+2][col] = 0;

                        }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row+1][col]){
                            TilesPosition[row][col] = merge(TilesPosition[row+1][col]);
                            score += TilesPosition[row][col];
                            TilesPosition[row+1][col] = 0;
                        }
                    }
                break;
            default:
                break;                
        }// switch(swapDir)
        
        TilesArray.clear();
        
        for(col=0 ; col<3 ; col++){
            for(row =0 ; row <3 ; row ++){
                if (TilesPosition[row][col] != 0){
                    int lbl = TilesPosition[row][col];
                    Square s = new Square(col*tileDim.SIZE, row*tileDim.SIZE, getColor(lbl),lbl);
                    TilesArray.add(s);
                }
            }
        }
        validMove = !arrayOp(TilesPosition,oldTilesPosition,"Compare");
    } // move
    
    private boolean arrayOp(int [][] src, int [][] out, String op){
        switch(op){
            case "Compare":
                for(int row =0 ; row<src.length ; row++){
                    for(int col =0 ; col<src.length ; col++){
                        if(src[row][col]!=out[row][col])
                            return false;
                    }

            }
                break;
            case "Copy":
                for(int row =0 ; row<3 ; row++){
                    for(int col =0 ; col<3 ; col++){
                        out[row][col]=src[row][col];
                        
                    }
            }
                break;
                default:
                    break;          
        }
        return true;
    }
    
    protected int merge(int lbl){
        double old_Lbl_Pow = Math.log(lbl)/Math.log(2);
        return (int)Math.pow(2,old_Lbl_Pow+1);
    }
    
    protected void setSwapDir(swapDirection dir){
        this.swapDir = dir;
    } 
    
    protected void setHscore(){
        try{
        if (score>Hscore)
            this.Hscore = this.score;
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Documents\\NetBeansProjects\\Project\\src\\resources"));
        writer.newLine();
        writer.write(Integer.toString(Hscore));
        writer.flush();
        writer.close();
        }catch(Exception e){
            
        }
    }
    
    public int getScore(){
        return this.score;
    }

    protected boolean checkMove(){return validMove;}
    
    protected int getHscore(){
        return this.Hscore;
    } 
    
    protected boolean noEmptyTile(){
        boolean returnValue = true;
        for(int col=0 ; col<3 ; col++){
            for(int row =0 ; row <3 ; row++){
                if (TilesPosition[row][col] == 0){
                    returnValue = false;   
                    break;
                }
            }   
        }
        return returnValue;
    }
    
    protected boolean gameOver(){
        if(noEmptyTile()){
            for(int row=0 ; row<3 ; row++){
                for(int col =0 ; col <3 ; col++){
                    if(row<2 && TilesPosition[row][col] == TilesPosition[row+1][col])
                        return false;
                    if(col<2 && TilesPosition[row][col] == TilesPosition[row][col+1])
                        return false;
                }
            }
            return true;
        }
        return false;
    }// gameOver

    protected Color getColor(int number){
        switch(number){
            case 2:
                return Color.BLUE;
            case 4:
                return Color.ORANGE;
            case 8:
                return Color.RED;
            case 16:
                return Color.PINK;
            case 32:
                return Color.MAGENTA;
            case 64:
                return Color.CYAN;
            case 128:
                return Color.BLACK;
            case 256:
                return Color.GRAY;
            case 512:
                return Color.DARK_GRAY;
            case 1024:
                return Color.LIGHT_GRAY;
            case 2048:
                return Color.WHITE;
            default:
                return Color.BLUE;
        }
    } // getColor
    
    protected void generateTile(boolean v){
        if(v){
            int row1 = tileDim.rand.nextInt(3);               
            int col1 = tileDim.rand.nextInt(3);
            while(TilesPosition[row1][col1] != 0){
                row1 = tileDim.rand.nextInt(3);               
                col1 = tileDim.rand.nextInt(3);              
            }
            int lbl1 = TilesPosition[row1][col1]=tileDim.LBL_PROP[tileDim.rand.nextInt(9)];
            Square s1 = new Square (col1*tileDim.SIZE, row1*tileDim.SIZE, getColor(lbl1), lbl1);
            TilesArray.add(s1);
        }

        } //  generateTile
    
    protected void restartgame(){
        TilesArray.clear();
        int[][] newTilesPosition = new int[][]{
  { 0, 0, 0 },
  { 0, 0, 0 },
  { 0, 0, 0 }};
        this.TilesPosition = newTilesPosition;
        generateTile(true);
        generateTile(true);
        score = 0;
    }
    
    public void draw(Graphics g){
        for(int i=0;i<TilesArray.size();i++)
            ((Square)TilesArray.get(i)).draw(g);
    }
    
}// class tile
