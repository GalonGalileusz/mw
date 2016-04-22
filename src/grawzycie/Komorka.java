/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grawzycie;

/**
 *
 * @author Dendelion
 */
public class Komorka {
    
//    int i, j;
    private int stan;
    private int zywy, umarly;
    
    public Komorka(){
//        this.i = i;
//        this.j = i;
        zywy = 0;
        umarly = 0;
        //stan = 0;
    }
    

    
    public void setState(int stan){
        this.stan=stan;
    }
    
    public int getState(){
        return stan;
    }
    
    public void setAlive(int zywy){
        this.zywy=zywy;
    }
    
    public int getAlive(){
        return zywy;
    }
    
    public void setDead(int umarly){
        this.umarly=umarly;
    }
    
    public int getDead(){
        return umarly;
    }
    
    public void addD(){
        umarly++;
    }
    
    public void addA(){
        zywy++;
    }
}
