/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3.student.solution1;

import java.util.Scanner;

/**
 *
 * @author Ryan Schissel
 */
public class KeyboardInput implements MessageInput {

    @Override
    public String inputMessage() {
        System.out.print("Please enter a message: ");
        Scanner kybd = new Scanner(System.in);
        return kybd.nextLine();
    }

}
