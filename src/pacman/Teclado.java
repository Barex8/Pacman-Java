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
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        String key;
        
        while(true){
            try{
                sleep(400);
                key = sc.next(); 
                System.out.println(key);
            }catch(Exception e){
                
            }
            
        }
    }    
}
