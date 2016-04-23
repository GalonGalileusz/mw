/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Dendelion
 */
public class Board extends JPanel implements Runnable{
    
    private int size = 20;
        
    private Cell [][]tab = new Cell[size][size];
    private final Cell [][]temp = new Cell[size][size];;
    
    public Conditions cond;
        
        public Board(){
            
        cond = new Conditions();
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                tab[i][j] = new Cell();
                tab[i][j].setState(0);
                
                temp[i][j] = new Cell();
                temp[i][j].setState(0);

            }
        }
             
        MouseListener mouseHandler = new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                
                int w = getWidth();
                int h = getHeight();
                              
                int cellW = w/size;
                int cellH = h/size;
                
                if(e.getX()>=0 && e.getY()>=0){
                    
                    int c = e.getX() / cellW;
                    int r = e.getY() / cellH;
                    
                    if(c>=0 && r>=0 && c<size && r<size){
                                            
                    switch (cond.getStruct()){
                        case 0: 
                            if(tab[r][c].getState()==0){
                            tab[r][c].setState(1);
                            }
                            else
                                tab[r][c].setState(0);
                            break;
                        case 1:
                            if(tab[r][c].getState()==0){
                                tab[r][c].setState(1);
                                tab[r][c+1].setState(1);
                                tab[r+1][c-1].setState(1);
                                tab[r+1][c+2].setState(1);
                                tab[r+2][c].setState(1);
                                tab[r+2][c+1].setState(1);
                            }
                            else
                                tab[r][c].setState(0);
                            break;
                        case 2:
                            if(tab[r][c].getState()==0){
                                tab[r][c].setState(1);
                                tab[r+1][c].setState(1);
                                tab[r+2][c].setState(1);
                            }
                            else
                                tab[r][c].setState(0);
                                
                            break;
                        case 3:
                            if(tab[r][c].getState()==0){
                                tab[r][c].setState(1);
                                tab[r][c+1].setState(1);
                                tab[r][c+2].setState(1);
                                tab[r+1][c].setState(1);
                                tab[r+2][c+1].setState(1);
                            }
                            else
                                tab[r][c].setState(0);
                            break;
                    }                          
                    }
                }                
                repaint();      
            }
        };
        addMouseListener(mouseHandler);
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

    @Override
    public void run() {
        
        System.out.println("Running ...");
        while(true){
            if(cond.getGameStatus()==1){
                 this.life();
                 repaint();
            }
            if(cond.getGameStatus()==2){
                this.clean();
                repaint();
            }
            try{
                Thread.sleep(500);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void life(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                
                /*----------NON-PERIODIC BOUNDARY CONDITION--------------------*/
                if(cond.getBC()==0){
                    if((i==0 || i==size-1) && (j==0 || j==size-1)){
                        tab[i][j].setDead(5);
                    }else if(i==0 || i==size-1 || j==0 || j==size-1){
                        tab[i][j].setDead(3);
                    }
                    /*-------CHECKING NEIGHBOURHOOD--------------*/           
                    for(int k=i-1; k<i+2; k++){
                        for(int l=j-1; l<j+2; l++){
                            if((k==i && l==j) || k<0 || k>=size || l<0 || l>=size){
                                continue; }
                            else if(tab[k][l].getState()==0){
                                tab[i][j].addD(); 
                            }
                            else
                                tab[i][j].addA();
                        }
                    }
                    /*--------------------------------------------*/                    
                    
                }else if(cond.getBC()==1){
                    for(int k=i-1; k<i+2; k++){
                        for(int l=j-1; l<j+2; l++){
                            
                            int kk, ll;
                            
                            if(k<0)
                                kk=size-1;
                            else if(k>=size)
                                kk=0;
                            else
                                kk=k;
                            
                            
                            if(l<0)
                                ll=size-1;
                            else if(l>=size)
                                ll=0;
                            else 
                                ll=l;
                            
                            if(k==i && l==j)
                                ;
                            else if(tab[kk][ll].getState()==0){
                                tab[i][j].addD();
                            }
                            else
                                tab[i][j].addA();
                        }
                    }                 
                }else{
            
                }

               if(tab[i][j].getState()==0 && tab[i][j].getAlive()==3)
                   temp[i][j].setState(1);
               else if(tab[i][j].getState()==1){
                       if(tab[i][j].getAlive()==3 || tab[i][j].getAlive()==2)
                            temp[i][j].setState(1);
                       else if(tab[i][j].getAlive()>3 || tab[i][j].getAlive()<2)
                            temp[i][j].setState(0);
               }
             
            }
        }
        
        System.out.println("----------------------");
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                tab[i][j].setState(temp[i][j].getState());
                tab[i][j].setAlive(0);
                tab[i][j].setDead(0);
                temp[i][j].setState(0);
            }
        }
    }
    
    public void clean(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                tab[i][j] = new Cell();
                tab[i][j].setState(0);
                
                temp[i][j] = new Cell();
                temp[i][j].setState(0);

            }
        }
    }
    }
    

