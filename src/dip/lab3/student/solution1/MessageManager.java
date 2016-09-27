/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3.student.solution1;

/**
 *
 * @author Ryan Schissel
 */
public class MessageManager {
    private Input input;
    private Output output;

    public MessageManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }
    
    public void doMessage(){
        String msg = input.inputMessage();
        output.outputMessage(msg);
    }
    
}
