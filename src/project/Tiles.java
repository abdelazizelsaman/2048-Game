package project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

class Tiles {
    protected Score s = new Score(0,0);
    private Random random = new Random();
    private ArrayList TilesArray = new ArrayList();
    private swapDirection swapDir = swapDirection.RIGHT;
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
    
    protected void moveCol(){
        int row ;
        int col = 2;
        int factor ;
        if (swapDir == swapDirection.RIGHT){
            factor = 1;
        }else{
            col = 0;
            factor = -1;
        }
        
        for( row=0 ; row<3 ; row++){
                        // Check if 1st tile in column is zero
            if(TilesPosition[row][col] == 0){
                if(TilesPosition[row][col-factor] == 0){
                    TilesPosition[row][col] = TilesPosition[row][col-2*factor];
                    TilesPosition[row][col-2*factor] = 0;

                }else{
                    if(TilesPosition[row][col-factor] == TilesPosition[row][col-2*factor]){
                        TilesPosition[row][col] = tileMerge(TilesPosition[row][col-factor]);
                        s.addScore(TilesPosition[row][col]);
                        TilesPosition[row][col-factor] = 0;
                        TilesPosition[row][col-2*factor] = 0;

                    }else{
                        TilesPosition[row][col] = TilesPosition[row][col-factor];
                        TilesPosition[row][col-factor] = TilesPosition[row][col-2*factor];
                        TilesPosition[row][col-2*factor] = 0;

                    }
                }
            }
            // Check if the 2nd tile in column is zero
            else if(TilesPosition[row][col-factor] == 0){
                    // Check if the 2nd & 3rd tiles are equal
                    if(TilesPosition[row][col] == TilesPosition[row][col-2*factor]){
                        TilesPosition[row][col] = tileMerge(TilesPosition[row][col-2*factor]);
                        s.addScore(TilesPosition[row][col]);
                        TilesPosition[row][col-2*factor] = 0;

                    }else{
                        TilesPosition[row][col-factor] = TilesPosition[row][col-2*factor];
                        TilesPosition[row][col-2*factor] = 0;

                    }
                    // check if the 1st & 2nd tile are equal
                }else if(TilesPosition[row][col-factor] != 0 && TilesPosition[row][col] == TilesPosition[row][col-factor]){
                        TilesPosition[row][col] = tileMerge(TilesPosition[row][col-factor]);
                        s.addScore(TilesPosition[row][col]);
                        TilesPosition[row][col-factor] = TilesPosition[row][col-2*factor];
                        TilesPosition[row][col-2*factor] = 0;

                    }else if(TilesPosition[row][col-factor] == TilesPosition[row][col-2*factor]){
                            TilesPosition[row][col-factor] = tileMerge(TilesPosition[row][col-2*factor]);
                            s.addScore(TilesPosition[row][col-factor]);
                            TilesPosition[row][col-2*factor] = 0;

            }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row][col-factor]){
                TilesPosition[row][col] = tileMerge(TilesPosition[row][col-factor]);
                s.addScore(TilesPosition[row][col]);
                TilesPosition[row][col-factor] = 0;
            }
        }
        
    }// moveCol
    
    protected void moveRow(){
        int row = 2;
        int col = 0;
        int factor = 0;
        if (swapDir == swapDirection.DOWN){
            factor = 1;
        }else{
            row = 0;
            factor = -1;
        }
        
        for(col=0 ; col<3 ; col++){
                // Check if 1st tile in column is zero
                if(TilesPosition[row][col] == 0){
                        if(TilesPosition[row-factor][col] == 0){
                                TilesPosition[row][col] = TilesPosition[row-2*factor][col];
                                TilesPosition[row-2*factor][col] = 0;

                        }else{
                                if(TilesPosition[row-factor][col] == TilesPosition[row-2*factor][col]){
                                        TilesPosition[row][col] = tileMerge(TilesPosition[row-factor][col]);
                                        s.addScore(TilesPosition[row][col]);
                                        TilesPosition[row-factor][col] = 0;
                                        TilesPosition[row-2*factor][col] = 0;

                                }else{
                                        TilesPosition[row][col] = TilesPosition[row-factor][col];
                                        TilesPosition[row-factor][col] = TilesPosition[row-2*factor][col];
                                        TilesPosition[row-2*factor][col] = 0;

                                }
                        }
                }
                // Check if the 2nd tile in column is zero
                else if(TilesPosition[row-factor][col] == 0){
                                // Check if the 2nd & 3rd tiles are equal
                                if(TilesPosition[row][col] == TilesPosition[row-2*factor][col]){
                                        TilesPosition[row][col] = tileMerge(TilesPosition[row-2*factor][col]);
                                        s.addScore(TilesPosition[row][col]);
                                        TilesPosition[row-2*factor][col] = 0;

                                }else{
                                        TilesPosition[row-factor][col] = TilesPosition[row-2*factor][col];
                                        TilesPosition[row-2*factor][col] = 0;

                                }
                                // check if the 1st & 2nd tile are equal
                        }else if(TilesPosition[row-factor][col] != 0 && TilesPosition[row][col] == TilesPosition[row-factor][col]){
                                        TilesPosition[row][col] = tileMerge(TilesPosition[row-factor][col]);
                                        s.addScore(TilesPosition[row][col]);
                                        TilesPosition[row-factor][col] = TilesPosition[row-2*factor][col];
                                        TilesPosition[row-2*factor][col] = 0;

                                }else if(TilesPosition[row-factor][col] == TilesPosition[row-2*factor][col]){
                                                TilesPosition[row-factor][col] = tileMerge(TilesPosition[row-2*factor][col]);
                                                s.addScore(TilesPosition[row-factor][col]);
                                                TilesPosition[row-2*factor][col] = 0;

                                }else if(TilesPosition[row][col] != 0 && TilesPosition[row][col] == TilesPosition[row-factor][col]){
                                                TilesPosition[row][col] = tileMerge(TilesPosition[row-factor][col]);
                                                s.addScore(TilesPosition[row][col]);
                                                TilesPosition[row-factor][col] = 0;
                }
        }
}// moveRow
    
    protected void move(){
    int [][] oldTilesPosition = new int[3][3];
    arrayCopy(TilesPosition, oldTilesPosition);
        int row = 0, col = 0;
        switch(this.swapDir){

            case RIGHT:
                moveCol();
                break;
                
            case LEFT:
                moveCol();
                break;
                
            case DOWN:
                moveRow();
                break;
                
            case UP:
                moveRow();
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
        validMove = !arrayCompare(TilesPosition,oldTilesPosition);
    } // move
    
    private boolean arrayCompare(int [][] src, int [][] out){
        for(int row =0 ; row<src.length ; row++){
                    for(int col =0 ; col<src.length ; col++){
                        if(src[row][col]!=out[row][col])
                            return false;
                    }
            }
        return true;
    }// arrayCompare
    
    private boolean arrayCopy(int [][] src, int [][] out){
        for(int row =0 ; row<3 ; row++){
                    for(int col =0 ; col<3 ; col++){
                        out[row][col]=src[row][col];        
                    }
            }
        return true;
    }// arrayCopy
        
    protected int tileMerge(int lbl){
        double old_Lbl_Pow = Math.log(lbl)/Math.log(2);
        return (int)Math.pow(2,old_Lbl_Pow+1);
    }// tileMerge
    
    protected void setSwapDir(swapDirection dir){
        this.swapDir = dir;
    } 
    
    protected boolean checkMove(){return validMove;}
    
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
    }// noEmptyTile
    
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
    
    protected boolean winner(){
        for(int row =0 ; row<TilesPosition.length ; row++){
                    for(int col =0 ; col<TilesPosition.length ; col++){
                        if(TilesPosition[row][col] == 2048)
                            return true;
                    }
        }
        return false;
    }// winner

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
    
    protected void restartGame(){
        TilesArray.clear();
        int[][] newTilesPosition = new int[][]{
  { 0, 0, 0 },
  { 0, 0, 0 },
  { 0, 0, 0 }};
        this.TilesPosition = newTilesPosition;
        generateTile(true);
        generateTile(true);
        s.setScore(0);
    }// restartGame
    
    public void draw(Graphics g){
        for(int i=0;i<TilesArray.size();i++)
            ((Square)TilesArray.get(i)).draw(g);
    }
    
}// class tile
