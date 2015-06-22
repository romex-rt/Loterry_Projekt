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
        System.out.println("=== Lottery Menu ===\n1 Enter ticket\n2 Lottery drawing\n3 Show result\n Quit\n Please enter (0-3):");
    }
 //test
}
    
