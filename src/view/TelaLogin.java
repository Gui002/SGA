/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmpregadoController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import static view.TelaPrincipal.*;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class TelaLogin extends JFrame implements ActionListener {

    private JLabel lbIcone, lbNome, lbPassword;
    private JTextField tfNome;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JPanel pnAdaptador, pnForm;
    TelaPrincipal p;

    public TelaLogin() {
        setSize(1366, 760);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        //Inicializando os paineis
        pnAdaptador = new JPanel(null);
        pnForm = new JPanel(null);

        //Dimensiondo paineis
        Sizer.resizeRelativeTo(pnAdaptador, this, .99f, .96f);
        Sizer.resizeRelativeTo(pnForm, pnAdaptador, .3f, .7f);

        //Colorindo pnForm
        pnForm.setBackground(Color.CYAN);
        //Adicionando os paineis na frame
        add(pnAdaptador);
        ComponentPlacer.centralizar(pnAdaptador, pnForm);

        //Inicializando os componentes da tela
        lbIcone = new JLabel(new ImageIcon("src/imagens/user.png"));
        lbNome = new JLabel("Nome");
        lbPassword = new JLabel("Password");
        tfNome = new JTextField();
        pfPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        lbIcone.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        Sizer.resizeRelativeTo(lbIcone, pnForm, .2f, .2f);
        Sizer.resizeRelativeTo(lbNome, pnForm, .15f, .05f);
        Sizer.resizeRelativeTo(lbPassword, lbNome, 1, 1);
        Sizer.resizeRelativeTo(tfNome, pnForm, .9f, .07f);
        Sizer.resizeRelativeTo(pfPassword, tfNome, 1, 1);
        Sizer.resizeRelativeTo(btnLogin, pnForm, .2f, .05f);

        ComponentPlacer.colocarEm(pnForm, lbIcone, ComponentPlacer.MIDDLE, ComponentPlacer.TOP);
        ComponentPlacer.offset(lbIcone, 0, 80);

        //Calculando padding Left/Right para a label do nome, tfNome
        int offsetH = 20, offsetV = lbIcone.getX() + lbIcone.getWidth() + 20;
        int Y = offsetH + lbNome.getWidth() + tfNome.getWidth();
        int paddingH = Sizer.offsets(1, pnForm.getWidth(), Y);

        ComponentPlacer.superiorEsquerdo(pnForm, tfNome, paddingH, offsetV);
        //ComponentPlacer.direita(pnForm, lbNome, tfNome, offsetH);
        ComponentPlacer.abaixo(pnForm, lbNome, lbPassword, 20);
        ComponentPlacer.direita(pnForm, lbPassword, pfPassword, offsetH);
        ComponentPlacer.colocarEm(pnForm, btnLogin, ComponentPlacer.MIDDLE, ComponentPlacer.BOTTOM);
        ComponentPlacer.offset(btnLogin, 0, -40);

        btnLogin.addActionListener(this);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            EmpregadoController acesso = EmpregadoController.getInstance();
            String Nome = tfNome.getText(), Senha = pfPassword.getText();
            Map<String, Object> empregado = acesso.getEmpregado(Nome, Senha);
            if (Nome.equals("") || Senha.equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha todos campos", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                if ((Nome.equals(empregado.get("nome"))) && (Senha.equals(empregado.get("senha")))) {
                    this.dispose();
                    p = new TelaPrincipal();
                    nome_usuario.setText("                       " + Nome.toUpperCase());
                    codigoEmpregado = (String) empregado.get("codigo");
                } else {
                    JOptionPane.showMessageDialog(this, "Acesso negado \nSenha ou Nome invalidos", "Alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }
}
