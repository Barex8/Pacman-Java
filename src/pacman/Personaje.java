/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

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
    
    private void DecidirMovimiento(){
       
        boolean pared;
        boolean movimientoDecidido = false;
        
        while(!movimientoDecidido){
            if(!player){
               movimientoDecidido = FantasmaMovimiento();
            }else{
               movimientoDecidido = PlayerMovimiento(Teclado.lastKeyPressed);
            }
        }
    }
    
    private boolean PlayerMovimiento(int dir){
        switch(dir){
       case 100:            //D
           if (tablero.ComprobarPared(posX,posY+1)) {
            tablero.MoverElemento(display, posX, posY, posX, posY+1);
            posY ++;
            return true;
           }
           break;
       case 97:             //A
           if (tablero.ComprobarPared(posX,posY-1)) {
            tablero.MoverElemento(display, posX, posY, posX, posY-1);
            posY --;
            return true;
           }
           System.out.println(tablero.tablero[posX][posY-1]+"       //////");
           break;
           case 119:        //S
           if (tablero.ComprobarPared(posX-1,posY)) {
               tablero.MoverElemento(display, posX, posY, posX-1, posY);
               posX --;
               return true;
           }
           break;
           case 115:        //W
           if (tablero.ComprobarPared(posX+1,posY)) {
               tablero.MoverElemento(display, posX, posY, posX+1, posY);
               posX ++;
               return true;
           }
           break;
           default:
               return false;
            
        }
       return false;
    
    }
    
    private boolean FantasmaMovimiento()
    {
     int x = (int)(Math.random()*4);
       switch(x){
       case 0:          
           if (tablero.ComprobarPared(posX+1,posY)) {
               tablero.MoverElemento(display, posX, posY, posX+1, posY);
               posX ++;
               return true;
           }
       case 1:
           if (tablero.ComprobarPared(posX-1,posY)) {
               tablero.MoverElemento(display, posX, posY, posX-1, posY);
               posX --;
               return true;
           }
           case 2:
           if (tablero.ComprobarPared(posX,posY+1)) {
               tablero.MoverElemento(display, posX, posY, posX, posY+1);
               posY ++;
               return true;
           }
           case 3:
           if (tablero.ComprobarPared(posX,posY-1)) {
               tablero.MoverElemento(display, posX, posY, posX, posY-1);
               posY --;
               return true;
           }
           return false;
       }
       return false;
    }
}
