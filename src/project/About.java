/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Cursor;

public class About extends JFrame {
    private Container con2 = new Container();
    private JLabel lblAbout = new JLabel(new ImageIcon(getClass().getResource("/resources/about-p.png")));
    private JButton btnMenu = new JButton(new ImageIcon(getClass().getResource("/resources/home.png")));
    
    public About(){
        this.setTitle("2048");
        this.setBounds(650, 200, 320, 440);
        this.setBackground(Color.decode("#969b9c"));
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(con2);
        
        this.add(btnMenu);
        this.add(lblAbout);
        lblAbout.setBounds(0, 0, 320, 340);
        lblAbout.setForeground(Color.white);
        btnMenu.setBounds(110, 340, 100, 50);
        btnMenu.setCursor(new Cursor(12));
        btnMenu.addActionListener(new ActionListener_Menu());
    }
    
    
    class ActionListener_Menu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Menu().setVisible(true);
            About.super.setVisible(false);
        }
    }// ActionListener_Play
    
}
