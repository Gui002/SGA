/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class TelaAluguer {

    private JPanel pnAluguer;
    private String[] linhas = {"Nome do cliente", "Data de aluguer", "Nome do material", "Codigo da unidade"};
    private String[][] dados = {};
    private JTable tbInfoAlugueis;
    private JScrollPane spnTabela;
    private JLabel lbLogo;

    public TelaAluguer() {
        
        tbInfoAlugueis = new JTable(dados, linhas);
        spnTabela = new JScrollPane(tbInfoAlugueis);
        tbInfoAlugueis.setEnabled(false);
        pnAluguer = new JPanel(null);
        
        //Fundo
        pnAluguer.setBackground(new Color(255, 247, 83, 159));
        
        //Tamanhos
        pnAluguer.setSize(1081, 656);        
        Sizer.resizeRelativeTo(spnTabela, pnAluguer, .98f, .60f);
        
        //Adicionando
        ComponentPlacer.centralizar(pnAluguer, spnTabela);
        

    }

    public JPanel getPnaluguer() {
        return pnAluguer;
    }

}
