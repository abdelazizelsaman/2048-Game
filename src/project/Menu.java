
package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import java.awt.Cursor;

class Menu extends JFrame{

    private JButton btnPlay = new JButton(new ImageIcon(getClass().getResource("/resources/play.png")));
    private JButton btnAbout = new JButton(new ImageIcon(getClass().getResource("/resources/about.png")));
    private JLabel pnl2048 = new JLabel(new ImageIcon(getClass().getResource("/resources/2048.png")));
    private Container con1 = new Container();
    
    
    public Menu(){
 
        this.setTitle("2048");
        this.setBounds(650, 200, 320, 440);
        this.setBackground(Color.decode("#969b9c"));
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(con1);
        
        
        this.add(btnAbout);
        this.add(btnPlay);
        this.add(pnl2048);
        
        
        pnl2048.setBounds(0, 0, 320, 200);
        pnl2048.setBackground(Color.red);

        btnPlay.setBounds(110, 220, 100, 100);
        btnAbout.setBounds(110, 340, 100, 50);
        
        btnPlay.setCursor(new Cursor(12));
        btnAbout.setCursor(new Cursor(12));
        
        btnPlay.addActionListener(new ActionListener_Play());
        btnAbout.addActionListener(new ActionListener_About());

    }
    
        class ActionListener_Play implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Game2048().setVisible(true);
            Menu.super.setVisible(false);
        }
    }// ActionListener_Play
        
        class ActionListener_About implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new About().setVisible(true);
            Menu.super.setVisible(false);
        }
    }// ActionListener_About

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
}// class Menu
