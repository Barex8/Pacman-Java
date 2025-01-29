/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import java.util.Scanner;

/**
 *
 * @author MEDAC
 */
public class Teclado extends Thread{
    
    Personaje pacman;
    
    public static int lastKeyPressed;
    public boolean reading = true;
    
    public Teclado(Personaje pacman){
        this.pacman = pacman;
        lastKeyPressed = 100;
        reading = true;
    }
   
    public void run(){      
        while(reading){
            try{
                int key = System.in.read();
                if (lastKeyPressed != key && key != 10) {
                 lastKeyPressed = key;
                 System.out.println(key);
                }
                
            }catch(Exception e){
                
            }
            
        }
    }    
}
