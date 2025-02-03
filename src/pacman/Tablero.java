/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

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
    
    public static String [][] tableroMovimiento = new String [15][19];
    
    boolean empezar;
    int dificultad;
    
    public static Semaphore semaforoFantasmas = new Semaphore(0);
    
    public void run(){
        PrepararTableroDeMovimiento();
        MenuDificultad();
        Pacman.EmpezarJugar();
        while(true){
            
            MostrarTablero();
            try{
                Pacman.time --;
                sleep(1000);
            }catch(Exception e){
                
            }
        }
    }
    
    private void MenuDificultad(){
        System.out.println("--------- PAC-MAN ---------");
        System.out.println("Que dificultad quieres jugar: 1.Fácil, 2.Intermedio, 3.Difícil");
        Scanner sc = new Scanner(System.in);
        dificultad = sc.nextInt();
        switch(dificultad){
            case 1:
                Pacman.time = 150;
                Pacman.vida = 5;
                break;
            case 2:
                Pacman.time = 100;
                Pacman.vida = 3;
                break;
            case 3:
                Pacman.time = 10;
                Pacman.vida = 1;
                break;
        }
        
    }
    
    private void MostrarTablero(){
        System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Vidas: "+Pacman.vida+"                  "+" Tiempo: "+Pacman.time);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 19; j++) {
                if (tableroMovimiento[i][j] == "") {
                System.out.print(tablero[i][j]+" ");
                }else System.out.print(tableroMovimiento[i][j]+" ");
                
            }
            System.out.println();
        }
    }
    
    public static void PrepararTableroDeMovimiento(){
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
            
        }else if (elemento.equals ("O")){
            ComprobarCocos(posX,posY);
            return true;
        }
     return false;   
    }
    
    public static void ComprobarPacman(int posX, int posY){
        String elemento = tableroMovimiento[posX][posY];
        
        if(elemento.equals("P")){
            //System.out.println("Han chocado con el Pacman");
            Pacman.vida--;
            if (Pacman.vida <= 0 || Pacman.time <= 0) {
                Pacman.GameOver();
            }else{
                Pacman.Reseteo();
                PrepararTableroDeMovimiento();  
            }
        }
    }
    
    public static void ComprobarFantasma(int posX, int posY){
        String elemento = tableroMovimiento[posX][posY];
        
        if(elemento.equals("F")){
            //System.out.println("Han chocado con el Fantasma");
            Pacman.vida--;
            if (Pacman.vida <= 0 || Pacman.time <= 0) {
                Pacman.GameOver();
            }else{
                Pacman.Reseteo();
                PrepararTableroDeMovimiento();  
            }
            
        }
    }
    
    public void ComprobarCocos(int posX, int posY){
        String elemento = tablero[posX][posY];
        //System.out.println("Cocos restantes: "+Pacman.cocos);
        
        if(elemento.equals("O")){
            Pacman.cocos --;
          tablero[posX][posY] = ".";
          if(Pacman.cocos <= 0){
            Pacman.HasGanado();
          }  
        }
    }
}
