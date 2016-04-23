/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dendelion
 */

public class GameOfLife {

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        // TODO code application logic here        
        new GameOfLife();
    }
       
    public GameOfLife(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                MyFrame mf = new MyFrame();               
                mf.setVisible(true);                            
            }
        });
    }
    
}
