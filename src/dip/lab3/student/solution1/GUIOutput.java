/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3.student.solution1;

import javax.swing.JOptionPane;

/**
 *
 * @author Ryan Schissel
 */
public class GUIOutput implements MessageOutput{

  
    @Override
    public void outputMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "A super awesome message has arrived!", 0);
    }
   
}
