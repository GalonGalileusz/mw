/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grawzycie;

import java.util.Scanner;

/**
 *
 * @author Dendelion
 */


/* no gui for now*/
public class GraWzycie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = 7;
        
        Komorka [][]tab = new Komorka[size][size];
        Komorka [][]temp = new Komorka[size][size];
              
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                tab[i][j] = new Komorka();
                tab[i][j].setState(0);
                
                temp[i][j] = new Komorka();
                temp[i][j].setState(0);

            }
        }
/*-----------STALA-------------------------*/
//        tab[2][1].setState(1);
//        tab[3][3].setState(1);
//        tab[1][2].setState(1);
//        tab[1][3].setState(1);
//        tab[2][4].setState(1);
//        tab[3][2].setState(1);
 
/*---------------OSCYLATOR------------------*/
//        tab[1][2].setState(1);
//        tab[2][2].setState(1);
//        tab[3][2].setState(1);
        
/*-------------------GLIDER--------------------*/
        tab[2][2].setState(1);
        tab[3][3].setState(1);
        tab[1][2].setState(1);
        tab[1][3].setState(1);
        tab[1][4].setState(1);

        
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(tab[i][j].getState());   
            }
            System.out.println();
        }
        
        
        int bc=1;
//        System.out.println("Podaj warunek brzegowy");
//        Scanner sc = new Scanner(System.in);
//        bc = sc.nextInt();

 for(int a=0;a<10;a++){     

/*---------------ITERATION OF EVERY SINGLE CELL-------------------------------------------*/        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                
                /*----------NON-PERIODIC BOUNDARY CONDITION--------------------*/
                if(bc==0){
                    if((i==0 || i==size-1) && (j==0 || j==size-1)){
                        tab[i][j].setDead(5);
                    }else if(i==0 || i==size-1 || j==0 || j==size-1){
                        tab[i][j].setDead(3);
                    }
                    /*-------CHECKING NEIGHBOURHOOD--------------*/           
                    for(int k=i-1; k<i+2; k++){
                        for(int l=j-1; l<j+2; l++){
                            //System.out.println("petla iteracja "+k+" "+l);
                            if((k==i && l==j) || k<0 || k>=size || l<0 || l>=size){
                                continue; }
                            else if(tab[k][l].getState()==0){
                                tab[i][j].addD(); //System.out.println("umarly: "+tab[i][j].getDead());
                            }
                            else
                                tab[i][j].addA();
                        }
                    }
                    /*--------------------------------------------*/                    
                    
                }else if(bc==1){
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
//                System.out.println("i , j:" +i+j); 
//                System.out.println("stan "+tab[i][j].getState()); 
//                System.out.println("zywy "+tab[i][j].getAlive()); 
//                System.out.println("uamry "+tab[i][j].getDead());
//                System.out.println("----------------------"); 
               
               
               if(tab[i][j].getState()==0 && tab[i][j].getAlive()==3)
                   temp[i][j].setState(1);
               else if(tab[i][j].getState()==1){
                       if(tab[i][j].getAlive()==3 || tab[i][j].getAlive()==2)
                            temp[i][j].setState(1);
                       else if(tab[i][j].getAlive()>3 || tab[i][j].getAlive()<2)
                            temp[i][j].setState(0);
               }
               
//               tab[i][j].setAlive(0);
//               tab[i][j].setDead(0);
               
            }
        }
        
        System.out.println("----------------------");
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                tab[i][j].setState(temp[i][j].getState());
                tab[i][j].setAlive(0);
                tab[i][j].setDead(0);
                temp[i][j].setState(0);
                System.out.print(tab[i][j].getState()); 
            }
            System.out.println();
        }
        
        // 1 time step - changing state in table
        
        // ptint it 
    }
    }    
    
}
