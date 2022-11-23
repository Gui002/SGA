package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import utilitario.*;

public class TelaProcesso  {

    JPanel pn_produto, pn_usuario, pn_processo;
    JLabel fotoEquipamento, fotoCliente, perfilClient, nomeEquip, categoria, identificacao, marca, taxa_diaria;
    JTextField nomeCliente,contacto, endereco;
    JButton cancelar, alugar;
    public TelaProcesso() {
        pn_processo = new JPanel();
        pn_produto = new JPanel();
        pn_usuario = new JPanel();
        pn_processo.setLayout(null);
        pn_usuario.setLayout(null);
        pn_produto.setLayout(null);
        nomeCliente = new JTextField("NOME DO CLIENTE");
        contacto = new JTextField("CONTACTO DO CLIENTE");
        alugar = new JButton("Alugar");
        cancelar = new JButton("Cancelar");
        fotoEquipamento = new JLabel("Foto do equipamento");
        fotoCliente = new JLabel("Perfil padrao");
        nomeEquip = new JLabel("Nome:  Britadeira");
        identificacao = new JLabel("ID: 8902348439040");
        marca = new JLabel("Marca: A melhor");
        taxa_diaria = new JLabel("Taxa: 250MZN");
        categoria = new JLabel("Categoria: Furadeira");

        //Cores 
        pn_produto.setBackground(Color.pink);
        pn_usuario.setBackground(Color.CYAN);
        fotoEquipamento.setForeground(Color.gray);
        fotoCliente.setForeground(Color.gray);
        pn_processo.setBackground(Color.yellow);
        nomeEquip.setBorder(BorderFactory.createLineBorder(Color.yellow));
        identificacao.setBorder(BorderFactory.createLineBorder(Color.yellow));
        marca.setBorder(BorderFactory.createLineBorder(Color.yellow));
        taxa_diaria.setBorder(BorderFactory.createLineBorder(Color.yellow));
        categoria.setBorder(BorderFactory.createLineBorder(Color.yellow));
        fotoEquipamento.setBorder(BorderFactory.createLineBorder(Color.green));
        fotoCliente.setBorder(BorderFactory.createLineBorder(Color.green));

        //Tamanhos
        pn_processo.setSize(1081, 656);
        Sizer.resizeRelativeTo(pn_produto, pn_processo, .5f, 1f);
        Sizer.resizeRelativeTo(pn_usuario, pn_processo, .5f, 1f);
        fotoEquipamento.setSize(new Dimension(120, 120));
        fotoCliente.setPreferredSize(new Dimension(120, 120));
        Sizer.resizeRelativeTo(marca, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(nomeEquip, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(identificacao, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(taxa_diaria, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(categoria, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(nomeCliente, pn_usuario, .9f, .07f);
        Sizer.resizeRelativeTo(contacto, pn_usuario, .9f, .07f);

        //Bordas
        nomeCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Nome")));
        contacto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Contacto")));

        //Adicionando
        ComponentPlacer.superiorEsquerdo(pn_processo, pn_produto);
        ComponentPlacer.superiorDireito(pn_processo, pn_usuario);
        //No painelProduto
        ComponentPlacer.colocarEm(pn_produto, fotoEquipamento, ComponentPlacer.LEFT, ComponentPlacer.TOP);
        ComponentPlacer.abaixo(pn_produto, fotoEquipamento, identificacao, 0);
        ComponentPlacer.abaixo(pn_produto, identificacao, nomeEquip, 0);
        ComponentPlacer.abaixo(pn_produto, nomeEquip, marca, 0);
        ComponentPlacer.abaixo(pn_produto, marca, taxa_diaria, 0);
        ComponentPlacer.abaixo(pn_produto, taxa_diaria, categoria, 0);

        //No painelCliente
        ComponentPlacer.colocarEm(pn_usuario, nomeCliente, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);
        ComponentPlacer.offset(nomeCliente, 0, 150);
        ComponentPlacer.abaixo(pn_usuario, nomeCliente, contacto);
        ComponentPlacer.offset(contacto, 0, 15);
        
//        marca.setLocation(Sizer.offsets(1, pn_produto.getWidth(), marca.getWidth(), 0), marca.getY());
//        int paddingH = Sizer.offsets(1, pn_produto.getWidth(), marca.getWidth(), 0);
//        int paddingV = Sizer.offsets(1, pn_produto.getHeight(), marca.getHeight(), 0);
//         marca.setLocation(paddingH, paddingV);
    }

    public JPanel getPn_processo() {
        return pn_processo;
    }

 
}
