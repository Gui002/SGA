/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmpregadoController;
import controller.Enumeracoes;
import controller.MaterialController;
import utilitario.Sizer;
import utilitario.ComponentPlacer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author Fabricio
 */
public class TelaPrincipal implements ActionListener, MouseListener {

    private JPanel pnCima, pnEsquerdo, pnPrincipal, pnAdaptador, painelActivo;
    private JPanel pnCategorias;
    private JTextField tfPesquisar;
    public static JLabel lbImagemPesquisar, lbMain, lbSelecionarCategoria, nome_usuario;
    private JButton[] btnCategorias;
    private JComboBox cbxCategoria;
    private JButton btnInventario, btnAddProd, btnAluguer, btnHome, btnClientes, btnlogout, btnrelatorio;
    public static String codigoEmpregado;
    //Telas
    private TelaAdicionar add = new TelaAdicionar();
    private TelaAluguer alg = new TelaAluguer();
    private TelaCliente clt = new TelaCliente();
    private TelaProcesso pc = new TelaProcesso();
    private EmpregadoController emp = EmpregadoController.getInstance();
    JFrame tela;

    public TelaPrincipal() {
        tela = new JFrame();
        codigoEmpregado = " " + -1;
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(null);
        tela.setSize(1366, 767);
        tela.setLocationRelativeTo(null);
        btnInventario = new JButton("INVENTARIO");
        btnAddProd = new JButton("ADICIONAR");
        btnAluguer = new JButton("ALUGUER");
        btnClientes = new JButton("CLIENTES");
        btnHome = new JButton("HOME");
        btnlogout = new JButton("LOGOUT");
        btnrelatorio = new JButton("GERAR RELATORIO");
        String nome = "Guilherme";
        nome_usuario = new JLabel("                       " + nome);
        Font fonte = new Font("Arial", 10, 15);
        JLabel btn_HomeIcon = new JLabel(new ImageIcon("src/imagens/home_amarelo.png"));
        JLabel btn_RelatorioIcon = new JLabel(new ImageIcon("src/imagens/relatorio.png"));
        JLabel btn_LogoutIcon = new JLabel(new ImageIcon("src/imagens/logout.png"));
        JLabel btn_AddIcon = new JLabel(new ImageIcon("src/imagens/add.png"));
        JLabel btn_ClientIcon = new JLabel(new ImageIcon("src/imagens/clientes.png"));
        JLabel btn_AluguerIcon = new JLabel(new ImageIcon("src/imagens/aluguer.png"));
        JLabel btn_InvetIcon = new JLabel(new ImageIcon("src/imagens/inventario.png"));
        JLabel usuario = new JLabel(new ImageIcon("src/imagens/login.png"));
        pnCima = new JPanel(null);
        pnEsquerdo = new JPanel(null);
        pnCategorias = new JPanel(null);
        pnPrincipal = new JPanel(null);
        pnAdaptador = new JPanel(null);
        painelActivo = pnPrincipal;

        //Adicionando Icones
        //btnAddProd.add(btn_AddIcon);
        btnHome.add(btn_HomeIcon);
        btnAluguer.add(btn_AluguerIcon);
        btnInventario.add(btn_InvetIcon);
        btnClientes.add(btn_ClientIcon);
        btnlogout.add(btn_LogoutIcon);
        btnrelatorio.add(btn_RelatorioIcon);

        //Extra
        btnHome.setFocusable(false);
        btnAluguer.setFocusable(false);
        btnClientes.setFocusable(false);
        btnInventario.setFocusable(false);
        btnlogout.setFocusable(false);
        btnrelatorio.setFocusable(false);
        btnAddProd.setVisible(false);

        pnPrincipal.setLayout(null);
        //Bordas btn
        // btnAddProd.setBorder(BorderFactory.createEmptyBorder());
        btnHome.setBorder(BorderFactory.createEmptyBorder());
        btnAluguer.setBorder(BorderFactory.createEmptyBorder());
        btnClientes.setBorder(BorderFactory.createEmptyBorder());
        btnInventario.setBorder(BorderFactory.createEmptyBorder());
        btnlogout.setBorder(BorderFactory.createEmptyBorder());
        btnrelatorio.setBorder(BorderFactory.createEmptyBorder());
        // pnAdaptador.setLayout(null);

        //Fontes
        // btnAddProd.setFont(fonte);
        btnHome.setFont(fonte);
        btnAluguer.setFont(fonte);
        btnClientes.setFont(fonte);
        btnInventario.setFont(fonte);
        btnlogout.setFont(fonte);
        btnrelatorio.setFont(fonte);
        nome_usuario.setFont(fonte);

        //Colorir btns
        //btnAddProd.setBackground(new Color(62, 62, 62));
        //btnAddProd.setForeground(Color.WHITE);
        btnHome.setBackground(new Color(62, 62, 62));
        btnHome.setForeground(Color.WHITE);
        btnAluguer.setBackground(new Color(62, 62, 62));
        btnAluguer.setForeground(Color.WHITE);
        btnClientes.setBackground(new Color(62, 62, 62));
        btnClientes.setForeground(Color.WHITE);
        btnInventario.setBackground(new Color(62, 62, 62));
        btnInventario.setForeground(Color.WHITE);
        btnlogout.setBackground(new Color(62, 62, 62));
        btnlogout.setForeground(Color.WHITE);
        btnrelatorio.setBackground(new Color(62, 62, 62));
        btnrelatorio.setForeground(Color.WHITE);
        nome_usuario.setForeground(Color.WHITE);

        //Colorir paineis
        pnPrincipal.setBackground(Color.MAGENTA);
        pnCima.setBackground(Color.yellow);
        pnEsquerdo.setBackground(new Color(62, 62, 62));
        pnCima.setBackground(new Color(62, 62, 62));
        pnPrincipal.setBackground(new Color(255, 247, 83, 159));
        pnCategorias.setBackground(new Color(255, 247, 83, 159));

        //Bordas 
        pnCima.setBorder(BorderFactory.createBevelBorder(1, new Color(62, 62, 62), Color.white));
        //pnEsquerdo.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.red));
        //Definir tamanhos
        Sizer.resizeRelativeTo(pnAdaptador, tela, .99f, .96f);
        Sizer.resizeRelativeTo(pnCima, pnAdaptador, 0.8f, 0.1f);
        Sizer.resizeRelativeTo(pnEsquerdo, pnAdaptador, .2f, 1);
        Sizer.resizeRelativeTo(pnPrincipal, pnAdaptador, .8f, .9f);
        Sizer.resizeRelativeTo(pnCategorias, pnPrincipal, 1f, .8f);

        //Adicionando paineis
        tela.add(pnAdaptador);
        ComponentPlacer.superiorEsquerdo(pnAdaptador, pnEsquerdo);
        ComponentPlacer.direita(pnAdaptador, pnEsquerdo, pnCima);
        ComponentPlacer.abaixo(pnAdaptador, pnCima, pnPrincipal);
        ComponentPlacer.colocarEm(pnPrincipal, pnCategorias, ComponentPlacer.MIDDLE, ComponentPlacer.BOTTOM);
        ComponentPlacer.offset(pnCategorias, 0, -20);

        //Inicializar componentes do painel principal 
        tfPesquisar = new JTextField("Pesquisar...");
        lbImagemPesquisar = new JLabel(new ImageIcon("src/imagens/imagem_search.png"));
        btnCategorias = new JButton[6];
        lbSelecionarCategoria = new JLabel("SELECIONAR CATEGORIA");
        lbMain = new JLabel("Main");
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
        cbxCategoria = new JComboBox(ctgs);

        //Adicionando as labels de categorias
        for (int i = 0; i < btnCategorias.length; i++) {
            btnCategorias[i] = new JButton();
            // btnCategorias[i] = new JButton("categoria" + i);
            Sizer.resizeRelativeTo(btnCategorias[i], pnCategorias, .2f, .4f);
            btnCategorias[i].addActionListener(this);
            btnCategorias[i].setBackground(Color.CYAN);
            btnCategorias[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        //Imagens iniciais para btns
        btnCategorias[0].setIcon(new ImageIcon("src/imagens/Andaimes/andaime.jpg"));
        btnCategorias[1].setIcon(new ImageIcon("src/imagens/Acesso e elevacao/Empilhadeira.jpg"));
        btnCategorias[2].setIcon(new ImageIcon("src/imagens/Compactacao/compactador_solo.jpg"));
        btnCategorias[3].setIcon(new ImageIcon("src/imagens/Concretagem/betoneira_150.jpg"));
        btnCategorias[4].setIcon(new ImageIcon("src/imagens/Furacao e Demolicao/furadeira_impacto.jpg"));
        btnCategorias[5].setIcon(new ImageIcon("src/imagens/Gerador bomba compressor/compressor_conservatorio.jpg"));

        //Calculando padding
        int offsetH = 100;
        int X = pnCategorias.getWidth();
        int Y = btnCategorias[0].getWidth();
        int paddingH = Sizer.offsets(3, X, Y, offsetH);

        int offsetV = 40;
        X = pnCategorias.getHeight();
        Y = btnCategorias[0].getHeight();
        int paddingV = Sizer.offsets(2, X, Y, offsetV);

        ComponentPlacer.superiorEsquerdo(pnCategorias, btnCategorias[0], paddingH, paddingV);

        for (int i = 1; i < btnCategorias.length; i++) {
            if (i == 3) {
                ComponentPlacer.abaixo(pnCategorias, btnCategorias[0], btnCategorias[i], offsetV);
            } else {
                ComponentPlacer.direita(pnCategorias, btnCategorias[i - 1], btnCategorias[i], offsetH);
            }
        }

        //Tamnho dos components
        Sizer.resizeRelativeTo(tfPesquisar, pnPrincipal, .5f, .05f);
        Sizer.resizeRelativeTo(lbImagemPesquisar, tfPesquisar, .1f, 1);
        Sizer.resizeRelativeTo(lbSelecionarCategoria, pnPrincipal, .15f, .05f);
        Sizer.resizeRelativeTo(cbxCategoria, pnPrincipal, .2f, .05f);
        Sizer.resizeRelativeTo(btnInventario, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(usuario, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(nome_usuario, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(btnrelatorio, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(btnAluguer, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(btnHome, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(btnlogout, pnEsquerdo, 1f, .09f);
        Sizer.resizeRelativeTo(btnClientes, pnEsquerdo, 1f, .09f);

        //Adiciondo componentes em paineis
        ComponentPlacer.superiorEsquerdo(pnPrincipal, tfPesquisar, 60, 10);
        ComponentPlacer.direita(pnPrincipal, tfPesquisar, lbImagemPesquisar, 0);
        ComponentPlacer.direita(pnPrincipal, lbImagemPesquisar, lbSelecionarCategoria, 20);
        ComponentPlacer.direita(pnPrincipal, lbSelecionarCategoria, cbxCategoria, 1);
        ComponentPlacer.centralizar(pnEsquerdo, btnInventario);
        //ComponentPlacer.abaixo(pnEsquerdo, btnInventario, btnAddProd);
        ComponentPlacer.abaixo(pnEsquerdo, btnInventario, btnAluguer);
        // ComponentPlacer.abaixo(pnEsquerdo, btnAddProd, btnAluguer);
        ComponentPlacer.acima(pnEsquerdo, btnInventario, btnClientes);
        ComponentPlacer.acima(pnEsquerdo, btnClientes, btnHome);
        ComponentPlacer.abaixo(pnEsquerdo, btnAluguer, btnrelatorio);
        ComponentPlacer.colocarEm(pnEsquerdo, btnlogout, ComponentPlacer.LEFT, ComponentPlacer.BOTTOM);
        ComponentPlacer.colocarEm(pnEsquerdo, usuario, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);
        ComponentPlacer.abaixo(pnEsquerdo, usuario, nome_usuario, 0);
        //Eventos
        btnInventario.addActionListener(this);
      //  btnAddProd.addActionListener(this);
        btnAluguer.addActionListener(this);
        btnHome.addActionListener(this);
        btnClientes.addActionListener(this);
        btnlogout.addActionListener(this);

        btnHome.addMouseListener(this);
       // btnAddProd.addMouseListener(this);
        btnAluguer.addMouseListener(this);
        btnClientes.addMouseListener(this);
        btnInventario.addMouseListener(this);
        btnlogout.addMouseListener(this);

       //tela.setResizable(false);
        tela.setVisible(true);
    }

    public JPanel getPainelActivo() {
        return painelActivo;
    }

    public void setPainelActivo(JPanel painelActivo) {
        this.painelActivo = painelActivo;
    }

    //Tratamento de eventos
    @Override
    public void actionPerformed(ActionEvent ae) {
        JPanel activo = this.getPainelActivo();
        if (ae.getSource() == btnAddProd) {
            activo.setVisible(false);
            add.getPnAdicionar().setVisible(true);
            ComponentPlacer.abaixo(pnAdaptador, pnCima, add.getPnAdicionar());
            this.setPainelActivo(add.getPnAdicionar());
        }
        if (ae.getSource() == btnAluguer) {
            activo.setVisible(false);
            alg.getPnaluguer().setVisible(true);
            ComponentPlacer.abaixo(pnAdaptador, pnCima, alg.getPnaluguer());
            this.setPainelActivo(alg.getPnaluguer());
        }
        if (ae.getSource() == btnHome) {
            activo.setVisible(false);
            pnPrincipal.setVisible(true);
            ComponentPlacer.abaixo(pnAdaptador, pnCima, pnPrincipal);
            this.setPainelActivo(pnPrincipal);
        }
        if (ae.getSource() == btnClientes) {
            activo.setVisible(false);
            clt.getPnClientes().setVisible(true);
            ComponentPlacer.abaixo(pnAdaptador, pnCima, clt.getPnClientes());
            this.setPainelActivo(clt.getPnClientes());
        }
        if (ae.getSource() == btnCategorias[0]) {
            activo.setVisible(false);
            pc.getPn_processo().setVisible(true);
            ComponentPlacer.abaixo(pnAdaptador, pnCima, pc.getPn_processo());
            pc.Material(2, (ImageIcon) btnCategorias[0].getIcon());
            this.setPainelActivo(pc.getPn_processo());
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
        if (me.getSource() == btnHome) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnHome.setBackground(new Color(155, 155, 155));
            btnHome.setForeground(Color.yellow);

        }
        if (me.getSource() == btnAddProd) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnAddProd.setBackground(new Color(155, 155, 155));
            btnAddProd.setForeground(Color.yellow);

        }
        if (me.getSource() == btnAluguer) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnAluguer.setBackground(new Color(155, 155, 155));
            btnAluguer.setForeground(Color.yellow);

        }
        if (me.getSource() == btnInventario) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnInventario.setBackground(new Color(155, 155, 155));
            btnInventario.setForeground(Color.yellow);

        }
        if (me.getSource() == btnClientes) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnClientes.setBackground(new Color(155, 155, 155));
            btnClientes.setForeground(Color.yellow);

        }
        if (me.getSource() == btnlogout) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnlogout.setBackground(new Color(155, 155, 155));
            btnlogout.setForeground(Color.yellow);

        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btnHome) {
            btnHome.setBackground(new Color(62, 62, 62));
            btnHome.setForeground(Color.WHITE);
        }
        if (me.getSource() == btnAddProd) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnAddProd.setBackground(new Color(62, 62, 62));
            btnAddProd.setForeground(Color.WHITE);

        }
        if (me.getSource() == btnAluguer) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnAluguer.setBackground(new Color(62, 62, 62));
            btnAluguer.setForeground(Color.WHITE);

        }
        if (me.getSource() == btnInventario) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnInventario.setBackground(new Color(62, 62, 62));
            btnInventario.setForeground(Color.WHITE);

        }
        if (me.getSource() == btnClientes) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnClientes.setBackground(new Color(62, 62, 62));
            btnClientes.setForeground(Color.WHITE);

        }
        if (me.getSource() == btnlogout) {
            //btnHome.setBackground(new Color(63, 185, 216));
            btnlogout.setBackground(new Color(62, 62, 62));
            btnlogout.setForeground(Color.WHITE);

        }

    }

    public static String getCodigoEmpregado() {
        return codigoEmpregado;
    }

}
