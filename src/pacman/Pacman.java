/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacman;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;;

/**
 *
 * @author MEDAC
 */
public class Pacman {
    public static int cocos = 4;
    public static int vida;
    public static int time;
    
    static Tablero tablero = new Tablero();

    static Personaje player = new Personaje(true,1000,9,9,tablero);
    static Personaje fantasma1 = new Personaje(false,1000,10,7,tablero);
    static Personaje fantasma2 = new Personaje(false,1000,9,7,tablero);
    static Personaje fantasma3 = new Personaje(false,1000,8,7,tablero);
    static Personaje fantasma4 = new Personaje(false,1000,9,6,tablero);

    static Teclado teclado = new Teclado(player);
    
    public static void main(String[] args) {
        tablero.start();
       
    }
    
    public static void Reseteo(){
        player.SetPos(9,9);
        fantasma1.SetPos(7,10);
        fantasma2.SetPos(7,9);
        fantasma3.SetPos(7,8);
        fantasma4.SetPos(6,9);
        
    }
    
    public static void EmpezarJugar(){
        teclado.start();
        fantasma1.start();
        fantasma2.start();
        fantasma3.start();
        fantasma4.start();

        player.start();
    }
    
    public static  void HasGanado(){   
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
        System.out.println(" -------------- ¡¡HAS GANADO!! --------------");
        
        System.exit(0); 
        
    }
    
    public static void GameOver(){
        
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
        System.out.println(" -------------- ¡¡GAME OVER!! --------------");   
        
        
        System.exit(0);
        
    }
}
