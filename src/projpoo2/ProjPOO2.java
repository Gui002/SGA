/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projpoo2;
import controller.Enumeracoes;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import view.*;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class ProjPOO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new TelaPrincipal(); 
        //Mudei este comentario
        //Alteracoes funcionando
        //Alteracoes no DAO CRUD, unidade, material, categoria, 
        model.dao.UnidadeDAO ud = new model.dao.UnidadeDAO();
        ud.remover(new model.vo.Unidade(1, 1, Enumeracoes.Disponibilidade.DISPONIVEL, Enumeracoes.EstadoDeConservacao.CONSERVADO));
        System.out.println((java.util.ArrayList) ud.selecionar());
    }
    
}
