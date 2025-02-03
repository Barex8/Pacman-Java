/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import java.util.concurrent.Semaphore;

public class Personaje extends Thread{
    public boolean player;
    private String display;
    public int cooldownMovimiento;
    
    private int posX,posY;
    
    private Tablero tablero;
    
   
    
    private static int[] playerPos = new int[2];
    
    private int lastKeyPressed;
    
    public Personaje(boolean esJugador,int cooldownMovimiento,int posY,int posX,Tablero tablero){
        this.player = esJugador;
        if (player) display = "P";
        else display = "F";
        
        this.tablero = tablero;
        this.posX = posX;
        this.posY = posY;
        this.cooldownMovimiento = cooldownMovimiento;
    }   
    
    
    public void run(){
        tablero.MoverElemento(display, posX, posY, posX, posY);
      
        while(true){
            
            try{
                sleep(cooldownMovimiento);
                DecidirMovimiento();
                if (player) {
                    playerPos[0] = posX;
                    playerPos[1] = posY;
                }
            }catch(Exception e){}
        }
    }
    
    public void SetPos(int x, int y){
        posX = x;
        posY = y;
        tablero.MoverElemento(display, posX, posY, x, y);
    }
    
    private void DecidirMovimiento(){
       
        boolean pared;
        boolean movimientoDecidido = false;
        if(!player){
            try{
                Tablero.semaforoFantasmas.acquire();
            }catch(Exception e){ }
        }
        if(!player){
           FantasmaMovimiento();
        }else{
           PlayerMovimiento(Teclado.lastKeyPressed);
        }
        
        if (player) {
            Tablero.semaforoFantasmas.release();
            Tablero.semaforoFantasmas.release();
            Tablero.semaforoFantasmas.release();
            Tablero.semaforoFantasmas.release();
            
        }
        
    }    
    private void PlayerMovimiento(int dir){
        
        switch(dir){
            case 100:            //D
                if (tablero.ComprobarPared(posX,posY+1)) {
                    Tablero.ComprobarFantasma(posX,posY+1);
                 tablero.MoverElemento(display, posX, posY, posX, posY+1);
                 posY ++;
                
                }
                break;
            case 97:             //A
               if (tablero.ComprobarPared(posX,posY-1)) {
                   Tablero.ComprobarFantasma(posX,posY-1);
                tablero.MoverElemento(display, posX, posY, posX, posY-1);
                posY --;
                
               }
               System.out.print("");
               break;
            case 119:        //S
               if (tablero.ComprobarPared(posX-1,posY)) {
                   Tablero.ComprobarFantasma(posX-1,posY);
                   tablero.MoverElemento(display, posX, posY, posX-1, posY);
                   posX --;
               }
               break;
            case 115:        //W
               if (tablero.ComprobarPared(posX+1,posY)) {
                   Tablero.ComprobarFantasma(posX+1,posY);
                   tablero.MoverElemento(display, posX, posY, posX+1, posY);
                   posX ++;
                   
               }
               break;
        }
    }
    
    private void FantasmaMovimiento()
    {
        boolean decidido = false;
        while(!decidido){
          int x = (int)(Math.random()*4);
          switch(x){
            case 0:          
                if (tablero.ComprobarPared(posX+1,posY)) {
                    Tablero.ComprobarPacman(posX+1,posY);
                    tablero.MoverElemento(display, posX, posY, posX+1, posY);
                    posX ++;
                    decidido = true;
                    
                    
                }
                break;
            case 1:
                if (tablero.ComprobarPared(posX-1,posY)) {
                    Tablero.ComprobarPacman(posX-1,posY);
                    tablero.MoverElemento(display, posX, posY, posX-1, posY);
                    posX --;
                    decidido = true;
                }
                break;
            case 2:
                if (tablero.ComprobarPared(posX,posY+1)) {
                    Tablero.ComprobarPacman(posX,posY+1);
                    tablero.MoverElemento(display, posX, posY, posX, posY+1);
                    posY ++;
                    decidido = true;
                }
                break;
            case 3:
                if (tablero.ComprobarPared(posX,posY-1)) {
                    Tablero.ComprobarPacman(posX,posY-1);
                    tablero.MoverElemento(display, posX, posY, posX, posY-1);
                    posY --;
                    decidido = true;
                }
                break;
            }
        }
    }
     
}
