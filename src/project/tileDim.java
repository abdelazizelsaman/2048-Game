/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;

/**
 *
 * @author user
 */

enum swapDirection {RIGHT,LEFT,UP,DOWN};

class tileDim{
    // Grid Size (Square)
    public static int GRID_SIZE = 240;
    // tile size (Square)
    public static int SIZE = tileDim.GRID_SIZE/3;
    // tile text label position on the tile
    public static int LBL_x = 32;
    public static int LBL_Y = 52;
    // Array used to obtain the probalilty of having a "4" labeled tile, which is 10%.
    public static int[] LBL_PROP = {2,2,2,2,2,4,2,2,2,2};
    public static Random rand = new Random();
    // method to generate the tile color depending on the tile label.
    
}//  class tileDim
