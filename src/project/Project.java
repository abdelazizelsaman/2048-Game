/*
 * Date & Time : 5/11/2018 - 07:00 pm
 * CSE 126 Computer Programing 2
 * Course Project : 2D Game "2048(3x3 mode)"  
 * Submitted by: Ahmed Mohamed Abdel Aziz
 * ID: 14p1064
 * Submitted to: Dr Cherif Salama - Eng Eslam Mounier
 */
package project;

public class Project {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
                    public void run(){
                        new Menu().setVisible(true);
                    }
        });
    }  
}
