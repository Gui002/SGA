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
    
    public boolean novoAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(
                codigoCliente,
                codigoUnidade, 
                codigoEmpregado,
                (Date) java.util.Date.from(Instant.now()),
                null);
        return aluguelDAO.inserir(aluguel);
    }
    
    public boolean adicionarDevolucao(int codigoAluguel, Date data_devolucao, EstadoDeConservacao estadoDeConservacao){
        return aluguelDAO.atualizarAluguel(codigoAluguel, data_devolucao, estadoDeConservacao);
    }
    
    public boolean removerAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(codigoCliente, codigoUnidade, codigoEmpregado, null, null);
        return aluguelDAO.remover(aluguel);
    }
}
