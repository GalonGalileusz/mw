/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Dendelion
 */
public class Cell {

    private int state;
    private int alive, dead;
    
    public Cell(){
        alive = 0;
        dead = 0;
    }

    public void setState(int state){
        this.state=state;
    }
    
    public int getState(){
        return state;
    }
    
    public void setAlive(int alive){
        this.alive=alive;
    }
    
    public int getAlive(){
        return alive;
    }
    
    public void setDead(int dead){
        this.dead=dead;
    }
    
    public int getDead(){
        return dead;
    }
    
    public void addD(){
        dead++;
    }
    
    public void addA(){
        alive++;
    }
}
