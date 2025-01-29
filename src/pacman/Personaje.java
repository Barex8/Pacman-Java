/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

public class Personaje extends Thread{
    public boolean player;
    private String display;
    public int cooldownMovimiento;
    
    private int posY,posX;
    
    private Tablero tablero;
    
    private static int[] playerPos = new int[2]; 
    
    public Personaje(boolean esJugador,int cooldownMovimiento,int posX,int posY,Tablero tablero){
        this.player = esJugador;
        if (player) display = "P";
        else display = "F";
        
        this.tablero = tablero;
        this.posY = posY;
        this.posX = posX;
        this.cooldownMovimiento = cooldownMovimiento;
    }   
    
    public void run(){
        tablero.MoverElemento(display, posY, posX, posY, posX);
      
        while(true){
            
            try{
                sleep(cooldownMovimiento);
                DecidirMovimiento();
                if (player) {
                    playerPos[0] = posY;
                    playerPos[1] = posX;
                }
            }catch(Exception e){}
        }
    }
    
    private void DecidirMovimiento(){
       
        boolean pared;
        boolean movimientoDecidido = false;
        
        while(!movimientoDecidido){
             int x = (int)(Math.random()*4);
             //System.out.println(x);
            switch(x){
            case 0:
                if (tablero.ComprobarPared(posY+1,posX)) {
                    tablero.MoverElemento(display, posY, posX, posY+1, posX);
                    posY ++;
                    movimientoDecidido = true;
                    break;
                }
            case 1:
                if (tablero.ComprobarPared(posY-1,posX)) {
                    tablero.MoverElemento(display, posY, posX, posY-1, posX);
                    posY --;
                    movimientoDecidido = true;
                    break;
                }
                case 2:
                if (tablero.ComprobarPared(posY,posX+1)) {
                    tablero.MoverElemento(display, posY, posX, posY, posX+1);
                    posX ++;
                    movimientoDecidido = true;
                    break;
                }
                case 3:
                if (tablero.ComprobarPared(posY,posX-1)) {
                    tablero.MoverElemento(display, posY, posX, posY, posX-1);
                    posX --;
                    movimientoDecidido = true;
                    break;
                }
                break;
        }
    }
        
        
        
    }
    
    
}
