/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import utilitario.*;

/**
 *
 * @author ADMIN
 */
public class TelaAdicionar extends JFrame implements ActionListener, MouseListener {

    JPanel pnAdicionar, pnAdd;
    public static JTextField nome, marca, campoTaxa;
    public static JLabel taxa, categoria;
    public static JComboBox categorias;
    JButton btnCancelar, btnAdicionar;
    Controller c = new Controller();

    public TelaAdicionar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pnAdicionar = new JPanel();
        pnAdd = new JPanel();
        nome = new JTextField("Digite o nome do equipamento");
        marca = new JTextField("Digite a marca do equipamento");
        campoTaxa = new JTextField();
        taxa = new JLabel("Taxa ");
        btnCancelar = new JButton("CANCELAR");
        btnAdicionar = new JButton("ADICIONAR");
        categoria = new JLabel("Categoria ");
        Font f = new Font("", 0, 30);
        taxa.setFont(f);
        categoria.setFont(f);
        String[] ctgs = {
            "ANDAIMES",
            "COMPACTAÇÃO",
            "CONCRETAGEM",
            "EQUIPAMENTOS DE JARDINAGEM",
            "EQUIPAMENTOS DE LIMPEZA",
            "EQUIPAMENTOS PARA ACESSO E ELEVAÇÃO",
            "EQUIPAMENTOS PARA FURAÇÃO E DEMOLIÇÃO",
            "FERRAMENTAS ELÉTRICAS",
            "GERADOR",
            "BOMBA",
            "COMPRESSOR"};
        categorias = new JComboBox(ctgs);

        //Tamanhos
        this.setSize(1081, 656);
        pnAdicionar.setSize(1081, 656);
        Sizer.resizeRelativeTo(pnAdd, pnAdicionar, .5f, 1f);
        Sizer.resizeRelativeTo(nome, pnAdd, .9f, .07f);
        Sizer.resizeRelativeTo(marca, pnAdd, .9f, .07f);
        Sizer.resizeRelativeTo(campoTaxa, pnAdd, .3f, .07f);
        Sizer.resizeRelativeTo(categorias, pnAdd, .5f, .07f);
        Sizer.resizeRelativeTo(btnCancelar, pnAdd, .3f, .07f);
        Sizer.resizeRelativeTo(btnAdicionar, pnAdd, .3f, .07f);

        //Cores
        pnAdd.setBackground(new Color(255, 247, 83, 200));
        pnAdicionar.setBackground(new Color(255, 247, 83, 159));
        btnAdicionar.setBackground(new Color(85, 255, 66, 151));
        btnCancelar.setBackground(new Color(255, 66, 66, 151));

        //Configs
        btnAdicionar.setFocusable(false);
        //Layouts
        this.setLayout(null);
        pnAdicionar.setLayout(null);
        pnAdd.setLayout(null);

        //Bordas
        //pnAdd.setBorder(BorderFactory.createTitledBorder("Adicionar"));
        marca.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Marca")));
        categorias.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Categoria")));
        campoTaxa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Taxa")));
        nome.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Nome")));
        btnAdicionar.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        btnCancelar.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

        //Adicando no painel
        ComponentPlacer.centralizar(pnAdicionar, pnAdd);
        ComponentPlacer.colocarEm(pnAdd, nome, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);
        ComponentPlacer.offset(nome, 0, 150);
        ComponentPlacer.abaixo(pnAdd, nome, marca);
        ComponentPlacer.offset(marca, 0, 15);
        ComponentPlacer.abaixo(pnAdd, marca, campoTaxa);
        ComponentPlacer.offset(campoTaxa, 0, 15);
        ComponentPlacer.direita(pnAdd, campoTaxa, categorias);
        ComponentPlacer.offset(categorias, 54, 0);
        ComponentPlacer.inferiorEsquerdo(pnAdd, btnAdicionar);
        ComponentPlacer.offset(btnAdicionar, 0, -10);
        ComponentPlacer.esquerda(pnAdd, btnAdicionar, btnCancelar);
        ComponentPlacer.offset(btnAdicionar, 10, 0);

        //Eventos
        btnAdicionar.addActionListener(this);
        btnAdicionar.addMouseListener(this);
        btnCancelar.addActionListener(this);
        btnCancelar.addMouseListener(this);
        nome.addMouseListener(this);
//        this.add(pnAdicionar);
//
//        this.setVisible(true);

    }

    public JPanel getPnAdicionar() {
        return pnAdicionar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdicionar) {
            // c.adicionaMaterial();
            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso");
            //  nome.setText("Digite o nome do equipamento");

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btnAdicionar) {
            btnAdicionar.setBackground(Color.GREEN);
            btnAdicionar.setForeground(Color.WHITE);
        }

        if (me.getSource() == btnCancelar) {
            btnCancelar.setBackground(Color.RED);
            btnCancelar.setForeground(Color.WHITE);
        }

        if (me.getSource() == nome) {
            nome.setText("");
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btnAdicionar) {
            btnAdicionar.setBackground(new Color(255, 247, 83, 159));
            btnAdicionar.setForeground(Color.BLACK);
        }

        if (me.getSource() == btnCancelar) {
            btnCancelar.setBackground(new Color(255, 66, 66, 240));
            btnCancelar.setForeground(Color.BLACK);
        }

        if (me.getSource() == nome) {
            if (nome.getText().equalsIgnoreCase("")) {
                nome.setText("Digite o nome do equipamento");
            }
        }
    }

}
