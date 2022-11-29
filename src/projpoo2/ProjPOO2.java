/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projpoo2;
import controller.AluguelController;
import controller.Enumeracoes;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Date;
import javax.swing.*;
import view.*;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class ProjPOO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new TelaPrincipal(); 
       System.out.println(AluguelController.getInstance().registrarDevolucao("8_84920121", "1", 1, new Date(System.currentTimeMillis()), Enumeracoes.EstadoDeConservacao.CONSERVADO));
    }
    
}
