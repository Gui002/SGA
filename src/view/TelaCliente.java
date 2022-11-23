/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import utilitario.ComponentPlacer;
import utilitario.Sizer;

/**
 *
 * @author ADMIN
 */
public class TelaCliente extends JFrame {

    private JTable tabelaClientes;
    private String[] headClientes = {"ID", "NOME DO CLIENTE", "DATA DE ALUGUER"};
    private String[][] dados = {};
    private JScrollPane jsp;
    private JPanel pnClientes;

    public TelaCliente() {
        pnClientes = new JPanel(null);
        tabelaClientes = new JTable(dados, headClientes);
        jsp = new JScrollPane(tabelaClientes);

        //Fundo
        pnClientes.setBackground(new Color(255, 247, 83, 159));

        //Tamanhos
        pnClientes.setSize(1081, 656);
        Sizer.resizeRelativeTo(jsp, pnClientes, .98f, .60f);

        //Adicionado
        ComponentPlacer.centralizar(pnClientes, jsp);

    }

    public JPanel getPnClientes() {
        return pnClientes;
    }

}
