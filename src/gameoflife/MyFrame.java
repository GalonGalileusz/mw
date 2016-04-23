/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dendelion
 */
public class MyFrame extends JFrame{
    
    private String[] bcs = new String[]{"Non-periodic", "Periodic"};
    private String[] structs = new String[]{"Constant", "Oscillator", "Glider"};
    private int bc=0;
    private int s = 0;
    private JPanel contentPane;
    private Board board;
    
    public MyFrame(){
        setTitle("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());      
        setSize(this.getPrefferredSize());
        
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel bcLabel = new JLabel("Set BC ");
        panel.add(bcLabel);
        
        JComboBox bcCombo = new JComboBox();
        bcCombo.setToolTipText("Boundary Conditions");
        bcCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                bc = bcCombo.getSelectedIndex();
            }
        });
        
        bcCombo.setModel(new DefaultComboBoxModel(this.bcs));
        panel.add(bcCombo);
        
        JLabel structLabel = new JLabel("Set structure ");
        panel.add(structLabel);
        
        JComboBox structCombo = new JComboBox();
//        structCombo.setToolTipText("Structure");
        structCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                s = structCombo.getSelectedIndex();
            }
        });
        
        structCombo.setModel(new DefaultComboBoxModel(this.structs));
        panel.add(structCombo);
        
        System.out.println("CHUJ");
        
        board = new Board();
        contentPane.add(board, BorderLayout.CENTER);
        
        setVisible(true);
    } 
    
    public Dimension getPrefferredSize(){
        return new Dimension(500, 500);
    }
}
