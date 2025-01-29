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

    
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        
        Personaje player = new Personaje(true,1000,9,9,tablero);
        Personaje fantasma1 = new Personaje(false,1000,10,7,tablero);
        Personaje fantasma2 = new Personaje(false,1000,9,7,tablero);
        Personaje fantasma3 = new Personaje(false,1000,8,7,tablero);
        Personaje fantasma4 = new Personaje(false,1000,9,6,tablero);
        
        Teclado teclado = new Teclado(player);
        
        teclado.start();
        tablero.start();
        fantasma1.start();
        fantasma2.start();
        fantasma3.start();
        fantasma4.start();

        player.start();
        
    }
}
