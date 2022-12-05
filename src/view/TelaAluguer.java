/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import controller.AluguelController;
import controller.ClienteController;
import controller.UnidadeController;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import model.vo.Aluguel;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class TelaAluguer {

    private JPanel pnAluguer;
    private String[] linhas = {"Nome do cliente", "Telefone", "Data de aluguer", "Nome do material", "Codigo da unidade"};
    private String[][] dados = new String[50][5];
    private JTable tbInfoAlugueis;
    private JScrollPane spnTabela;
    private JLabel lbLogo;
    JButton btnpagar;

    public TelaAluguer() throws IOException, DocumentException {
        this.preencher();
        tbInfoAlugueis = new JTable(dados, linhas);
        spnTabela = new JScrollPane(tbInfoAlugueis);
        tbInfoAlugueis.setEnabled(false);
        pnAluguer = new JPanel(null);
        btnpagar = new JButton("Pagar");
        //Fundo
        pnAluguer.setBackground(new Color(255, 247, 83, 159));

        //Tamanhos
        pnAluguer.setSize(1081, 656);
        Sizer.resizeRelativeTo(spnTabela, pnAluguer, .98f, .60f);
        Sizer.resizeRelativeTo(btnpagar, pnAluguer, .2f, .07f);

        //Adicionando
        ComponentPlacer.centralizar(pnAluguer, spnTabela);
//        ComponentPlacer.colocarEm(pnAluguer, btnpagar, ComponentPlacer.RIGHT, ComponentPlacer.BOTTOM);
//        ComponentPlacer.offset(btnpagar, -5, -10);

    }

    public void preencher() throws IOException, DocumentException {
        AluguelController alg = AluguelController.getInstance();
        ClienteController clt = ClienteController.getInstance();
        UnidadeController und = UnidadeController.getInstance();
        ArrayList<Aluguel> aluguel = alg._getAluguel();

        for (int i = 0; i < aluguel.size(); i++) {
            Map<String, Object> c = clt.getCliente(aluguel.get(i).getCodigoCliente());
            Map<String, Object> u = und.getUnidade(aluguel.get(i).getCodigoUnidade());
            dados[i][0] = "" + c.get("telefone");//Esta retorna nome do cliente
            dados[i][1] = "" + c.get("endereco");//Esta retornar Telefone
            dados[i][2] = "" + aluguel.get(i).getData_aluguel();
            dados[i][3] = "" + u.get("nome_material");
            dados[i][4] = "" + aluguel.get(i).getCodigoUnidade();    //Esta a retornar o endereco
////     
        }

        //  alg.gerarRelatorioInicial(dados[1][0],aluguel.get(1).getCodigoCliente() , dados[1][3], 0, aluguel.get(1).getData_aluguel(), "AluguelInicio.pdf", "src/imagens/ph.jpg");
    }

    public JPanel getPnaluguer() {
        return pnAluguer;
    }

}
