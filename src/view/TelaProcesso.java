package view;

import controller.AluguelController;
import controller.MaterialController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;
import utilitario.*;

public class TelaProcesso implements ActionListener {

    JPanel pn_produto, pn_usuario, pn_processo;
    public static JLabel fotoEquipamento, fotoCliente, perfilClient, nomeEquip, categoria, identificacao, marca_prod, taxa_diaria;
    JTextField nomeCliente, contacto, endereco;
    private MaterialController m;
    public JLabel foto_Equipamento;
    JButton btncancelar, btnalugar;
    
    public TelaProcesso() {
        m = MaterialController.getInstance();
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
        fotoEquipamento = new JLabel(new ImageIcon("src/imagens/Empilhadeira.jpg"));
        foto_Equipamento = new JLabel();
        fotoCliente = new JLabel("Perfil padrao");
        JLabel label_Nome = new JLabel(" Nome       :");
        nomeEquip = new JLabel();
        JLabel label_ID = new JLabel(" ID               :");
        identificacao = new JLabel();
        JLabel label_Marca = new JLabel(" Marca      :");
        marca_prod = new JLabel();
        JLabel label_taxa = new JLabel(" Taxa         :");
        taxa_diaria = new JLabel();
        JLabel label_categoria = new JLabel(" Categoria:");
        categoria = new JLabel();

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
        foto_Equipamento.setSize(new Dimension(120, 120));
        fotoCliente.setPreferredSize(new Dimension(120, 120));
        Sizer.resizeRelativeTo(foto_Equipamento, pn_produto, .8f, .4f);
        Sizer.resizeRelativeTo(fotoEquipamento, pn_produto, .8f, .4f);
        Sizer.resizeRelativeTo(label_Marca, pn_produto, 0.12f, 0.1f);
        Sizer.resizeRelativeTo(marca_prod, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(label_Nome, pn_produto, 0.12f, 0.1f);
        Sizer.resizeRelativeTo(nomeEquip, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(label_ID, pn_produto, 0.12f, 0.1f);
        Sizer.resizeRelativeTo(identificacao, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(label_taxa, pn_produto, 0.12f, 0.1f);
        Sizer.resizeRelativeTo(taxa_diaria, pn_produto, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(label_categoria, pn_produto, 0.12f, 0.1f);
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
        //ComponentPlacer.colocarEm(pn_produto, fotoEquipamento, ComponentPlacer.LEFT, ComponentPlacer.TOP);
        ComponentPlacer.colocarEm(pn_produto, foto_Equipamento, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);

        ComponentPlacer.abaixo(pn_produto, fotoEquipamento, label_ID, 0);
        ComponentPlacer.abaixo(pn_produto, label_ID, label_Nome, 0);
        ComponentPlacer.abaixo(pn_produto, label_Nome, label_Marca, 0);
        ComponentPlacer.abaixo(pn_produto, label_Marca, label_taxa, 0);
        ComponentPlacer.abaixo(pn_produto, label_taxa, label_categoria, 0);
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

        ComponentPlacer.abaixo(pn_usuario, contacto, endereco);
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

   
    public void Material(int codigo, ImageIcon j) {
        foto_Equipamento.setIcon(j);
        Map<String, Object> material = m.getMaterial(codigo);
        String nome = (String) material.get("nome");
        String marc = (String) material.get("marca");
        Float tax = (Float) material.get("taxa_diaria");
        int cat_code = (int) material.get("codigo_categoria");
        int code = (int) material.get("codigo");
        nomeEquip.setText(nome);
        identificacao.setText("" + code);
        marca_prod.setText(marc);
        taxa_diaria.setText("" + tax);
        categoria.setText("" + cat_code);

    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        AluguelController criarAluguer = AluguelController.getInstance();
        String codigoEmpregado = TelaPrincipal.getCodigoEmpregado();
        String telefoneCliente = Integer.toString(contacto.getX());
         System.out.println(codigoEmpregado);
        if (ae.getSource() == btnalugar) {
            criarAluguer.novoAluguel(Integer.parseInt(identificacao.getText()), codigoEmpregado, nomeCliente.getText(), telefoneCliente, endereco.getText());
            System.out.println("Lests Do it");
        }
    }


}
