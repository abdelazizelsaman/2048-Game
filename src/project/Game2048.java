/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Game2048 extends JFrame{

    private Tiles t = new Tiles();
    // Define & instantaite JPanels
    private JPanel pnl2048 = new JPanel();
    private JPanel pnlScore = new JPanel();
    private JPanel pnlHscore = new JPanel();
    private JPanel pnlBtns = new JPanel();
    private tilePnl pnlTiles = new tilePnl(t);
    //Define & instantiate JLabels
    private JLabel lbl2048 = new JLabel("2048");
    private JLabel lblScore = new JLabel("SCORE");
    private JLabel lblHscore = new JLabel("HIGHT SCORE");
    private JLabel txtScore = new JLabel(Integer.toString(t.getScore()));
    private JLabel txtHscore = new JLabel(Integer.toString(t.getHscore()));
    //Define & instantaite JButtom
    private JButton btnRestart = new JButton("R");
    private JButton btnMenu = new JButton("M");

    //Define & instantaite Conatainers
    private Container con = new Container();
    
    public Game2048(){
        
        gui();
        motion();
        
    } // Game2048
    
    private void gui(){
        // Set the JFrame Properties
        this.setTitle("2048 v1.0");
        this.setBounds(650, 200, 320, 440);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(con);
        
        // add JPanels to the JFrame Container
        this.add(pnlScore);
        this.add(pnlHscore);
        this.add(pnlBtns);
        this.add(pnlTiles);
        this.add(pnl2048);

        // Set Score JPanel Properties
        pnlScore.setLayout(new GridLayout(2,1));
        pnlScore.setBounds(148, 48, 40, 30);
        pnlScore.setBackground(Color.WHITE);
        pnlScore.add(lblScore);
        pnlScore.add(txtScore);

        lblScore.setFont(lblScore.getFont().deriveFont(10.0f));
        
        // Set HScore JPanel Properties
        pnlHscore.setLayout(new GridLayout(2,1));
        pnlHscore.setBounds(200, 48, 70, 30);
        pnlHscore.setBackground(Color.WHITE);
        pnlHscore.add(lblHscore);
        pnlHscore.add(txtHscore);
        
        lblHscore.setFont(lblHscore.getFont().deriveFont(10.0f));
        
        // Set buttons JPanel Properties
        pnlBtns.setLayout(new GridLayout(1,2));
        pnlBtns.setBounds(200, 90, 70, 30);
        pnlBtns.add(btnMenu);
        pnlBtns.add(btnRestart);
        btnMenu.setFont(btnMenu.getFont().deriveFont(10.0f));
        btnRestart.setFont(btnRestart.getFont().deriveFont(10.0f));
        
        // Set 2048 JPanel Properties
        pnl2048.setLayout(new BorderLayout());
        pnl2048.setBounds(40, 40, 80, 40);
        pnl2048.add(lbl2048,BorderLayout.CENTER);
        
        lbl2048.setFont(lbl2048.getFont().deriveFont(36.0f));
      
        // Set Tiles JPanel Properties
        pnlTiles.setLayout(new GridLayout(3,3));
        pnlTiles.setBounds(40, 140, tileDim.GRID_SIZE, tileDim.GRID_SIZE);
        pnlTiles.setBorder(BorderFactory.createLineBorder( Color.BLUE, 3, true));

    } // gui
    
    private void motion(){
        pnlTiles.addKeyListener(new KeyAdapter_tile());
        btnMenu.setFocusable(false);
        btnRestart.setFocusable(false);
        pnlTiles.setFocusable(true); 
        btnRestart.addActionListener(new ActionListener_Restart());
        btnMenu.addActionListener(new ActionListener_Menu());

    } // motion
   
    class KeyAdapter_tile extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                t.setSwapDir(swapDirection.RIGHT);
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                t.setSwapDir(swapDirection.LEFT);
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP){
                t.setSwapDir(swapDirection.UP);
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                t.setSwapDir(swapDirection.DOWN);
            }else{
                return;
            }
            
            // Move the tiles
            t.move();
            t.generateTile(t.checkMove());
            // Show the Score
            txtScore.setText(Integer.toString(t.getScore()));
            t.setHscore();
            txtHscore.setText(Integer.toString(t.getHscore()));
            // Repaint the Frame
            repaint();
            // Check Gameover condition
            if(t.gameOver())
                JOptionPane.showMessageDialog(null, "Game Over!");
       }
            
    }// class KeyAdapter_tile 

    class ActionListener_Restart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pnlTiles.setFocusable(true);
            t.restartgame();
            txtScore.setText(Integer.toString(t.getScore()));
            pnlTiles.repaint();
            txtScore.repaint();
            setFocusable(false);
            
        }
    }
    
    class ActionListener_Menu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pnlTiles.setFocusable(true);
        }
    }
}// Class Game2048

    
