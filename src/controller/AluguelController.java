/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.EstadoDeConservacao;
import java.time.Instant;
import java.sql.Date;
import model.dao.AluguelDAO;
import model.vo.Aluguel;


/**
 *
 * @author Fabricio
 */
public class AluguelController {
    private AluguelDAO aluguelDAO;
    
    public AluguelController(){
        aluguelDAO = new AluguelDAO();
    }
    
    public void novoAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(
                codigoCliente,
                codigoUnidade, 
                codigoEmpregado,
                (Date) java.util.Date.from(Instant.now()),
                null);
        aluguelDAO.inserir(aluguel);
    }
    
    public void adicionarDevolucao(int codigoAluguel, Date data_devolucao, EstadoDeConservacao estadoDeConservacao){
        aluguelDAO.atualizarAluguel(codigoAluguel, data_devolucao, estadoDeConservacao);
    }
    
    public void removerAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(codigoCliente, codigoUnidade, codigoEmpregado, null, null);
        aluguelDAO.remover(aluguel);
    }
}
