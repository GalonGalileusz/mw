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
public class Conditions {
    private int gameStatus, bc, struct;
    
    public Conditions(){
        gameStatus = 0;
        bc = 0;
        struct = 0;
    }
    
    public void setGameStatus(int arg){
        gameStatus = arg;
    }
    
    public int getGameStatus(){
        return gameStatus;
    }
    
    public void setBC(int arg){
        bc = arg;
    }
    
    public int getBC(){
        return bc;
    }
    
    public void setStruct(int arg){
        struct = arg;
    }
    
    public int getStruct(){
        return struct;
    }

}
