/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery_project;

import java.util.Scanner;

/**
 *
 * @author ROMEX
 */
public class IO {
    private Scanner sc;
    
    public IO() {
        sc = new Scanner(System.in);
    }
   
    public void printMenu(){
        System.out.println("=== Lottery Menu ===");
       System.out.println("1 Enter ticket");
       System.out.println("2 Lottery drawing");
       System.out.println("3 Show results");
       System.out.println("0 Quit");
       System.out.print("Please enter (0-3): ");
    }
}
    
