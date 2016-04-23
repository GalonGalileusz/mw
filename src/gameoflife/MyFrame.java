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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
    private String[] structs = new String[]{"Own", "Constant", "Oscillator", "Glider"};
    private JPanel contentPane;
    private Board board;
    private Conditions c;
    
    public MyFrame(){
        
        board = new Board();
        c = board.cond;
        
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
        bcCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                c.setBC(bcCombo.getSelectedIndex());
            }
        });
        
        bcCombo.setModel(new DefaultComboBoxModel(this.bcs));
        panel.add(bcCombo);
        
        JLabel structLabel = new JLabel("Set structure ");
        panel.add(structLabel);
        
        JComboBox structCombo = new JComboBox();
        structCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                c.setStruct(structCombo.getSelectedIndex());
            }
        });
        
        structCombo.setModel(new DefaultComboBoxModel(this.structs));
        panel.add(structCombo);
        
        JButton startButton = new JButton("Start");
        startButton.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                c.setGameStatus(1);
            }
        });
        
        JButton stopButton = new JButton("Stop");
        stopButton.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                c.setGameStatus(0);
            }
        });
        
        JButton cleanButton = new JButton("Clean");
        cleanButton.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                c.setGameStatus(2);
                //methods to clean board 
            }
        });
        
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(cleanButton);
        
        
        contentPane.add(board, BorderLayout.CENTER);
        
        new Thread(board).start();
        
        
    } 
    
    public Dimension getPrefferredSize(){
        return new Dimension(500, 500);
    }
    

}
