/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import utilitario.ComponentPlacer.*;
/**
 *
 * @author ADMIN
 */
public class TelaAddAluguer extends JFrame{

    public TelaAddAluguer() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1081, 656);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new TelaAddAluguer();
        //Pegar painel categoria e painel  principal
    }
    
}
