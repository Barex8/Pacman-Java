/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import static java.lang.Thread.sleep;

public class Tablero extends Thread{
    
    static String [][] tablero = {  //15x19
            {"[","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","]"},
            {"|",".",".",".",".",".",".",".",".","|",".",".",".",".",".",".",".",".","|"},
            {"|","O","-","-",".","[","-","-",".","|",".","-","-","]",".","-","-","O","|"},
            {"|",".",".",".",".","|",".",".",".",".",".",".",".","|",".",".",".",".","|"},
            {"|",".","-","-",".","|",".","-","-","-","-","-",".","|",".","-","-",".","|"},
            {"|",".",".",".",".","|",".",".",".",".",".",".",".","|",".",".",".",".","|"},
            {"|","-","-","-",".",".",".","[","|",".","|","]",".",".",".","-","-","-","|"},
            {".",".",".",".",".","|",".","|",".",".",".","|",".","|",".",".",".",".","."},
            {"|","-","-","-",".","|",".","[","-","-","-","]",".","|",".","-","-","-","|"},
            {"|",".",".",".",".","|",".",".",".",".",".",".",".","|",".",".",".",".","|"},
            {"|",".","-","-",".","|",".","-","-","-","-","-",".","|",".","-","-",".","|"},
            {"|",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","|"},
            {"|","O","-","-","-",".","-","-",".","|",".","-","-",".","-","-","-","O","|"},
            {"|",".",".",".",".",".",".",".",".","|",".",".",".",".",".",".",".",".","|"},
            {"[","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","]"}
    
    };
    
    String [][] tableroMovimiento = new String [15][19];
    
    public void run(){
        PrepararTableroDeMovimiento();
        
        while(true){
            
            MostrarTablero();
            try{
                sleep(1000);
            }catch(Exception e){
                
            }
        }
    }
    
    private void MostrarTablero(){
        System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 19; j++) {
                if (tableroMovimiento[i][j] == "") {
                System.out.print(tablero[i][j]+" ");
                }else System.out.print(tableroMovimiento[i][j]+" ");
                
            }
            System.out.println();
        }
    }
    
    private void PrepararTableroDeMovimiento(){
         for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 19; j++) {
                tableroMovimiento[i][j] = "";
            }
        }
    }
    
    public void MoverElemento(String tipo,int prevPosX, int prevPosY,int posX,int posY){
        tableroMovimiento[prevPosX][prevPosY] = "";
        tableroMovimiento[posX][posY] = tipo;
    }
    
    public boolean ComprobarPared(int posX, int posY){
        String elemento = "";
        
        if(!(posX <0 || posX >14)){
          elemento = tablero[posX][posY];  
        }else{
            return false;
        }
        
        if(!(posY <0 || posY >18)){
          elemento = tablero[posX][posY];  
        }else{
            return false;
        }
        

        if (elemento.equals(".")) {
            return true;
        }else if (elemento.equals ("O")) return true;
     return false;   
    }
}
