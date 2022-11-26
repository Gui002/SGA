/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.Instant;
import java.util.Date;
import model.dao.AluguelDAO;
import model.vo.Aluguel;
import model.vo.Cliente;
import model.vo.Empregado;
import model.vo.Unidade;

/**
 *
 * @author Fabricio
 */
public class AluguelController {
    private AluguelDAO aluguelDAO;
    
    public AluguelController(){
        aluguelDAO = new AluguelDAO();
    }
    
    public void novoAluguel(Cliente cliente, Empregado empregado, Unidade unidade){
        Aluguel aluguel = new Aluguel(
                cliente.getCodigo(),
                unidade.getCodigo(), 
                empregado.getCodigo(),
                (java.sql.Date)Date.from(Instant.now()),
                null);
        
        aluguelDAO.inserirSemDataDevolucao(aluguel);
    }
    
    public void adicionarDevolucao(){
    
    }
    
    public void removerAluguel(){
    
    }
}
