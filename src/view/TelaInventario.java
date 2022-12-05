/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.MaterialController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.vo.Cliente;
import model.vo.Material;
import utilitario.ComponentPlacer;
import utilitario.Sizer;

/**
 *
 * @author ADMIN
 */
public class TelaInventario {
    
    private JTable tabelaInventario;
    private String[] headClientes = {"CODIGO", "NOME DO MATERIAL", "TAXA DIARIA"};
    private String[][] dados = new String[50][3];
    private JScrollPane jsp;
    private JPanel pninventerio;

    public void fular() {
    }

    public TelaInventario() {
        this.preencher();
        pninventerio = new JPanel(null);
        tabelaInventario = new JTable(dados, headClientes);
        jsp = new JScrollPane(tabelaInventario);

        //Fundo
        pninventerio.setBackground(new Color(255, 247, 83, 159));

        //Tamanhos
        pninventerio.setSize(1081, 656);
        Sizer.resizeRelativeTo(jsp, pninventerio, .98f, .60f);

        //Adicionado
        ComponentPlacer.centralizar(pninventerio, jsp);

    }

    public void preencher() {
       MaterialController m = MaterialController.getInstance();
        ArrayList<Material> materias =m._getMaterial();

        for (int i = 0; i <materias.size(); i++) {
            dados[i][0] = Integer.toString(materias.get(i).getCodigo());
            dados[i][1] = materias.get(i).getNome(); //Esta a retornar nome do cliente
            dados[i][2] = Float.toHexString(materias.get(i).getTaxaDiaria());    //Esta a retornar o endereco
//     
        }
    }

    public JPanel getPnInventario() {
        return pninventerio;
    }
}
