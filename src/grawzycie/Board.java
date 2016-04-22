/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grawzycie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Dendelion
 */
public class Board extends JPanel{
       
    private int size = 20;
        
        Komorka [][]tab = new Komorka[size][size];
        Komorka [][]temp = new Komorka[size][size];
        
        public Board(){
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                tab[i][j] = new Komorka();
                tab[i][j].setState(0);
                
                temp[i][j] = new Komorka();
                temp[i][j].setState(0);

            }
        }
        
        tab[1][2].setState(1);
        tab[2][2].setState(1);
        tab[3][2].setState(1);
        
        
            
        
        MouseListener mouseHandler = new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                Point point = e.getPoint();
                
                int w = getWidth();
                int h = getHeight();
                
                int cellW = w/size;
                int cellH = h/size;
                
                //selectedCell = null;
                
                if(e.getX()>=0 && e.getY()>=0){
                    int c = e.getX() / cellW;
                    int r = e.getY() / cellH;
                    
                    if(c>=0 && r>=0 && c<size && r<size){
                        
                        tab[r][c].setState(1);
                        System.out.println("c: r: "+c+" "+r);
                    }
                }                
                repaint();      
            }
        };
        addMouseListener(mouseHandler);
    }
    
    
    public Dimension getPrefferredSize(){
        return new Dimension(500, 500);
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        int w = getWidth();
        int h = getHeight();
                
        int cellW = w/size;
        int cellH = h/size;
        
        int x = (w - size * cellW)/2;
        int y = (h - size * cellH)/2;
        
        
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                if(tab[i][j].getState()==0){
                    g2d.setColor(Color.white);
                }else{
                    g2d.setColor(Color.red);
                }
                
                Rectangle cell = new Rectangle(x + j*cellW,
                            y + i*cellH,
                            cellW-1,
                            cellH-1);
                g2d.fill(cell);

            }
        }
      
    }
}
