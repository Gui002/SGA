package testpack;

import controller.Enumeracoes;
import controller.Enumeracoes.Disponibilidade;
import controller.Enumeracoes.EstadoDeConservacao;
import controller.Enumeracoes.Sexo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import utilitario.ComponentPlacer;
import utilitario.Sizer;

public class TestPanel extends JPanel {

    private JPanel pnEntidades;
    private JPanel pnControle;
    private JPanel pnOperacao;
    private JPanel pnMain;
    private List<String> nomesAtuais = new ArrayList();

    private Map<String, JButton> bEntidades;
    private Map<String, JButton> bControle;
    private Map<String, JButton> bOperacoes;
    private HashMap<String, List<Component>> campos;
    private HashMap<String, JLabel> labels;
    
    private final ButtonGroup bgSexo = new ButtonGroup(), bgEstadoConservacao = new ButtonGroup(), bgDisponibilidade = new ButtonGroup();

    Color fundo1 = new Color(20, 26, 92);
    Color fundo2 = new Color(99, 95, 112);
    Color borderColor = new Color(245, 247, 187);
    Color btColor = new Color(16, 48, 44);
    Color fontColor = new Color(218, 255, 231);

    public TestPanel() {
        this.setLayout(null);
        this.setSize(960, 720);

        pnControle = new JPanel(null);
        pnEntidades = new JPanel(null);
        pnMain = new JPanel(null);
        pnOperacao = new JPanel(null);

        Sizer.resizeRelativeTo(pnEntidades, this, .25f, 1f);
        Sizer.resizeRelativeTo(pnOperacao, this, .75f, .1f);
        Sizer.resizeRelativeTo(pnControle, this, .75f, .2f);
        Sizer.resizeRelativeTo(pnMain, this, .75f, .7f);

        pnControle.setBorder(BorderFactory.createLineBorder(borderColor));
        pnEntidades.setBorder(BorderFactory.createLineBorder(borderColor));
        pnMain.setBorder(BorderFactory.createLineBorder(borderColor));
        pnOperacao.setBorder(BorderFactory.createLineBorder(borderColor));

        pnControle.setBackground(fundo2);
        pnEntidades.setBackground(fundo1);
        pnMain.setBackground(fundo1);
        pnOperacao.setBackground(fundo2);

        pnControle.setForeground(fontColor);
        pnEntidades.setForeground(fontColor);
        pnMain.setForeground(fontColor);
        pnOperacao.setForeground(fontColor);

        ComponentPlacer.superiorEsquerdo(this, pnEntidades);
        ComponentPlacer.direita(this, pnEntidades, pnOperacao);
        ComponentPlacer.abaixo(this, pnOperacao, pnMain);
        ComponentPlacer.abaixo(this, pnMain, pnControle);

        inicializarBotoes();
        inicializarLabels();
        inicializarCampos();
        preencherPainelEntidades();
        preencherPainelOperacoes();
        preencherPainelControle();
        bEntidadeActionListeners();

    }

    public void inserirCampos(Container container, Component refComponent, List<Component> campos, int offsetX) {
        Tracker<Component> c = new Tracker(refComponent);

        campos.forEach((componente) -> {
            ComponentPlacer.direita(container, c.getCurrent(), componente, offsetX);
            c.setCurrent(componente);
        });
    }

    private void addComponentsAtMain(List<String> nomeCampos) {
        Tracker<JLabel> c = new Tracker();
        int paddingX = 10;
        int paddingY = 50;
        int spacingX = 5;
        int spacingY = 10;

        nomeCampos.forEach((nome) -> {
            JLabel label = labels.get(nome);
            List<Component> camp = campos.get(nome);
            if (c.changeCount == 0) {
                ComponentPlacer.superiorEsquerdo(pnMain, label, paddingX, paddingY);
                c.setCurrent(label);
            } else {
                ComponentPlacer.abaixo(pnMain, c.getCurrent(), label, spacingY);
                c.setCurrent(label);
            }

            inserirCampos(pnMain, label, camp, spacingX);
        });
    }

    private void inicializarBotoes() {
        bEntidades = new HashMap();
        bEntidades.put("Categoria", new JButton());
        bEntidades.put("Material", new JButton());
        bEntidades.put("Unidade", new JButton());
        bEntidades.put("Cliente", new JButton());
        bEntidades.put("Empregado", new JButton());
        bEntidades.put("Aluguel", new JButton());

        bEntidades.forEach((nome, botao) -> {
            botao.setText(nome);
            botao.setBackground(btColor);
            botao.setForeground(fontColor);
        });

        bOperacoes = new HashMap();
        bOperacoes.put("Adicionar", new JButton());
        bOperacoes.put("Remover", new JButton());

        bOperacoes.forEach((nome, botao) -> {
            botao.setText(nome);
            botao.setBackground(btColor);
            botao.setForeground(fontColor);
        });

        bControle = new HashMap();

        bControle.put("Cancelar", new JButton());
        bControle.put("Limpar", new JButton());
        bControle.put("Efetuar", new JButton());

        bControle.forEach((nome, botao) -> {
            botao.setText(nome);
            botao.setBackground(btColor);
            botao.setForeground(fontColor);
        });

    }

    private void inicializarLabels() {
        labels = new HashMap();
        labels.put("Codigo", new JLabel());
        labels.put("Codigo do Cliente", new JLabel());
        labels.put("Codigo do Empregado", new JLabel());
        labels.put("Codigo da Unidade", new JLabel());
        labels.put("Codigo do Material", new JLabel());
        labels.put("Codigo da Categoria", new JLabel());
        labels.put("Nome", new JLabel());
        labels.put("Telefone", new JLabel());
        labels.put("Endereco", new JLabel());
        labels.put("Sexo", new JLabel());
        labels.put("Taxa diaria", new JLabel());
        labels.put("Estado de Conservacao", new JLabel());
        labels.put("Disponibilidade", new JLabel());
        labels.put("Senha", new JLabel());
        labels.put("Tipo", new JLabel());
        labels.put("Data de Inicio", new JLabel());
        labels.put("Data de Devolucao", new JLabel());

        labels.forEach((nome, label) -> {
            label.setText(nome);
            Sizer.resizeRelativeTo(label, pnMain, .2f, .05f);
            label.setForeground(fontColor);
        });

    }

    private void inicializarCampos() {
        campos = new HashMap();
        labels.forEach((nome, label) -> {
            JTextField tf = new JTextField();
            Sizer.resizeRelativeTo(tf, label, 2.5f, 1);
            List<Component> l = new ArrayList();
            l.add(tf);
            campos.put(nome, l);
        });
        
        String sexoComp[] =  {Sexo.F.toString(), Sexo.M.toString()};
        String disponibilidadeComp[] =  {Disponibilidade.DISPONIVEL.toString(), Disponibilidade.INDISPONIVEL.toString()};
        String conservacaoComp[] =  {EstadoDeConservacao.CONSERVADO.toString(), EstadoDeConservacao.DANIFICADO.toString()};
        
        addRadios("Sexo", Arrays.asList(sexoComp), bgSexo);
        addRadios("Disponibilidade", Arrays.asList(disponibilidadeComp), bgDisponibilidade);
        addRadios("Estado de Conservacao", Arrays.asList(conservacaoComp), bgEstadoConservacao);

    }

    private void addRadios(String nome, List<String> lista, ButtonGroup bg) {
        List<Component> ls = new ArrayList();
        JLabel label = labels.get(nome);
        lista.forEach((s) -> {
            JRadioButton rb = new JRadioButton(s);
            bg.add(rb);
            ls.add(rb);
            Sizer.resizeRelativeTo(rb, label, 1.25f, 1f);
        });

        campos.replace(nome, ls);
    }

    class Tracker<T> {

        private int changeCount = 0;
        private T current;

        public Tracker() {

        }

        public Tracker(T current) {
            this.current = current;
            changeCount = 1;
        }

        public T getCurrent() {
            return current;
        }

        public void setCurrent(T current) {
            this.current = current;
            changeCount++;
        }

        public int getChangeCount() {
            return changeCount;
        }

    }

    private void preencherPainelEntidades() {
        Tracker<JButton> c = new Tracker();
        int n = bEntidades.size();
        int w = pnEntidades.getWidth();
        int h = pnEntidades.getHeight();
        int bw = (int) (w * .9f);
        int bh = (int) (h * .05f);
        int yo = 5;
        int offsetX = Sizer.offsets(1, w, bw);
        int offsetY = Sizer.offsets(n, h, bh, yo);

        ArrayList<JButton> botoes = new ArrayList(bEntidades.values());
        botoes.sort((b1, b2) -> {
            return b1.getText().compareToIgnoreCase(b2.getText());
        });
        botoes.forEach((botao) -> {
            botao.setSize(bw, bh);
            if (c.getChangeCount() == 0) {
                ComponentPlacer.superiorEsquerdo(pnEntidades, botao, offsetX, offsetY);
                c.setCurrent(botao);

            } else {
                ComponentPlacer.abaixo(pnEntidades, c.current, botao, yo);
                c.setCurrent(botao);
            }
        });
    }

    private void preencherPainelOperacoes() {
        Tracker<JButton> c = new Tracker();
        int paddingX = 20;
        int spacingX = 10;
        ArrayList<JButton> botoes = new ArrayList(bOperacoes.values());
        botoes.sort((b1, b2) -> {
            return b1.getText().compareToIgnoreCase(b2.getText());
        });
        botoes.forEach((botao) -> {
            Sizer.resizeRelativeTo(botao, pnOperacao, .2f, .5f);
            if (c.getChangeCount() == 0) {
                ComponentPlacer.colocarEm(pnOperacao, botao, ComponentPlacer.LEFT, ComponentPlacer.MIDDLE);
                ComponentPlacer.offset(botao, paddingX, 0);
                c.setCurrent(botao);
            } else {
                ComponentPlacer.direita(pnOperacao, c.getCurrent(), botao, spacingX);
                c.setCurrent(botao);
            }
            System.out.println(botao.getText());
        });
    }

    private void preencherPainelControle() {
        Tracker<JButton> c = new Tracker();
        int paddingX = 30;
        int spacingX = 10;
        ArrayList<JButton> botoes = new ArrayList(bControle.values());
        botoes.sort((b1, b2) -> {
            return b1.getText().compareToIgnoreCase(b2.getText());
        });
        botoes.forEach((botao) -> {
            Sizer.resizeRelativeTo(botao, pnControle, .15f, .2f);
            if (c.getChangeCount() == 0) {
                ComponentPlacer.colocarEm(pnControle, botao, ComponentPlacer.RIGHT, ComponentPlacer.MIDDLE);
                ComponentPlacer.offset(botao, -paddingX, 0);
                c.setCurrent(botao);
            } else {
                ComponentPlacer.esquerda(pnControle, c.getCurrent(), botao, spacingX);
                c.setCurrent(botao);
            }
        });
    }

    public void bEntidadeActionListeners() {
        bEntidades.get("Categoria").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo", "Nome"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });

        bEntidades.get("Material").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo", "Nome", "Codigo do Material", "Taxa diaria"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });

        bEntidades.get("Unidade").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo", "Codigo do Material", "Disponibilidade", "Estado de Conservacao"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });

        bEntidades.get("Empregado").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo", "Nome", "Telefone", "Endereco", "Sexo", "Senha", "Tipo"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });

        bEntidades.get("Cliente").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo", "Nome", "Telefone", "Endereco"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });
        
        bEntidades.get("Aluguel").addActionListener((e) -> {
            pnMain.removeAll();
            String[] s = {"Codigo do Cliente", "Codigo do Empregado", "Codigo da Unidade", "Data de Inicio", "Data de Devolucao"};
            nomesAtuais.removeAll(nomesAtuais);
            nomesAtuais.addAll(Arrays.asList(s));
            addComponentsAtMain(Arrays.asList(s));
            this.repaint();
        });

    }

}
