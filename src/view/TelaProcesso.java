package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import utilitario.*;

public class TelaProcesso implements ActionListener{

    JPanel pn_produto, pn_usuario, pn_processo;
    public static JLabel fotoEquipamento, fotoCliente, perfilClient, nomeEquip, categoria, identificacao, marca_prod, taxa_diaria;
    JTextField nomeCliente,contacto, endereco;

    JButton btncancelar, btnalugar;
    public TelaProcesso() {
        pn_processo = new JPanel();
        pn_produto = new JPanel();
        pn_usuario = new JPanel();
        pn_processo.setLayout(null);
        pn_usuario.setLayout(null);
        pn_produto.setLayout(null);
        nomeCliente = new JTextField("NOME DO CLIENTE");
        contacto = new JTextField("CONTACTO DO CLIENTE");
        endereco = new JTextField("LOCALIZACAO");
        btnalugar = new JButton("Alugar");
        btncancelar = new JButton("Cancelar");
        fotoEquipamento = new JLabel("Foto do equipamento");
        fotoCliente = new JLabel("Perfil padrao");
        nomeEquip = new JLabel("Categoria:");
        JLabel label_ID = new JLabel("ID   :");
        identificacao = new JLabel("ID: 8902348439040");
        marca_prod = new JLabel("Marca: A melhor");
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
        marca_prod.setBorder(BorderFactory.createLineBorder(Color.yellow));
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
        Sizer.resizeRelativeTo(marca_prod, pn_produto, 0.8f, 0.1f);
        
        Sizer.resizeRelativeTo(nomeEquip, pn_produto, 0.8f, 0.1f);
        
        Sizer.resizeRelativeTo(label_ID, pn_produto, 0.12f, 0.1f);
        Sizer.resizeRelativeTo(identificacao, pn_produto, 0.8f, 0.1f);
        
        Sizer.resizeRelativeTo(taxa_diaria, pn_produto, 0.8f, 0.1f);
        
        Sizer.resizeRelativeTo(categoria, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(nomeCliente, pn_usuario, .9f, .07f);
        Sizer.resizeRelativeTo(contacto, pn_usuario, .9f, .07f);
        Sizer.resizeRelativeTo(endereco, pn_usuario, .9f, .07f);
        Sizer.resizeRelativeTo(btncancelar, pn_usuario, .3f, .07f);
        Sizer.resizeRelativeTo(btnalugar, pn_usuario, .3f, .07f);
       

        //Bordas
        nomeCliente.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Nome")));
        contacto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Contacto")));
        endereco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Local")));

        //Adicionando
        ComponentPlacer.superiorEsquerdo(pn_processo, pn_produto);
        ComponentPlacer.superiorDireito(pn_processo, pn_usuario);
        ComponentPlacer.colocarEm(pn_usuario, btnalugar, ComponentPlacer.LEFT, ComponentPlacer.BOTTOM);
        //No painelProduto
        ComponentPlacer.colocarEm(pn_produto, fotoEquipamento, ComponentPlacer.LEFT, ComponentPlacer.TOP);
        ComponentPlacer.abaixo(pn_produto, fotoEquipamento, label_ID, 0);
        ComponentPlacer.direita(pn_produto, label_ID, identificacao, 0);
        ComponentPlacer.abaixo(pn_produto, identificacao, nomeEquip, 0);
        ComponentPlacer.abaixo(pn_produto, nomeEquip, marca_prod, 0);
        ComponentPlacer.abaixo(pn_produto, marca_prod, taxa_diaria, 0);
        ComponentPlacer.abaixo(pn_produto, taxa_diaria, categoria, 0);

        //No painelCliente
        ComponentPlacer.colocarEm(pn_usuario, nomeCliente, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);
        ComponentPlacer.offset(nomeCliente, 0, 150);
        ComponentPlacer.abaixo(pn_usuario, nomeCliente, contacto);
        ComponentPlacer.offset(contacto, 0, 15);
        
        ComponentPlacer.abaixo(pn_usuario, contacto, endereco );
        ComponentPlacer.offset(endereco, 0, 15);
        
        //Eventos 
        btnalugar.addActionListener(this);
        
//        marca.setLocation(Sizer.offsets(1, pn_produto.getWidth(), marca.getWidth(), 0), marca.getY());
//        int paddingH = Sizer.offsets(1, pn_produto.getWidth(), marca.getWidth(), 0);
//        int paddingV = Sizer.offsets(1, pn_produto.getHeight(), marca.getHeight(), 0);
//         marca.setLocation(paddingH, paddingV);
    }
    
    public JLabel getNomeEquip() {
        return nomeEquip;
    }

    public void setNomeEquip(JLabel nomeEquip) {
        this.nomeEquip = nomeEquip;
    }
    

    public JPanel getPn_processo() {
        return pn_processo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnalugar){
            System.out.println("Lests Do it");
        }
    }

 
}
