/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpack;

import utilitario.*;
import controller.*;

import java.awt.EventQueue;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author Fabricio
 */
public class TestController {
    static enum T{ob, p, l, t};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("BD Manager");
        
        Thread thread = new Thread(() -> {
            JPanel p;
            f.add(p = new TestPanel());
            f.setSize(p.getWidth() + 15, p.getHeight() + 37);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
     
        EventQueue.invokeLater(thread);
        
        
    }
  
   
    

    
    
}
