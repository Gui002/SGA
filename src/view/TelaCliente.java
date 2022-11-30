/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.vo.Cliente;
import utilitario.ComponentPlacer;
import utilitario.Sizer;

/**
 *
 * @author ADMIN
 */
public class TelaCliente extends JFrame {

    private JTable tabelaClientes;
    private String[] headClientes = {"ID", "NOME DO CLIENTE", "ENDERECO"};
    private String[][] dados = new String[50][3];
    private JScrollPane jsp;
    private JPanel pnClientes;

    public void fular() {
    }

    public TelaCliente() {
        this.preencher();
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

    public void preencher() {
        ClienteController c = ClienteController.getInstance();
        ArrayList<Cliente> clientes = c._getCliente();

        for (int i = 0; i < clientes.size(); i++) {
            dados[i][0] = clientes.get(i).getCodigo();
            dados[i][1] = clientes.get(i).getTelefone(); //Esta a retornar nome do cliente
            dados[i][2] = clientes.get(i).getNome();    //Esta a retornar o endereco
//     
        }
    }

    public JPanel getPnClientes() {
        return pnClientes;
    }

}
