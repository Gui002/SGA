/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.EstadoDeConservacao;
import java.time.Instant;
import java.sql.Date;
import java.util.List;
import model.dao.AluguelDAO;
import model.dao.ClienteDAO;
import model.dao.UnidadeDAO;
import model.vo.Aluguel;
import model.vo.Cliente;
import model.vo.Material;
import model.vo.Unidade;
import utilitarios.Coleccoes;


/**
 *
 * @author Fabricio
 */
public class AluguelController {
    private AluguelDAO aluguelDAO;
    private static List<Aluguel> alugueis;
    private static long count = 0;
    
    public AluguelController(){
        aluguelDAO = new AluguelDAO();
        count = 1;
        atualizarLista();
    }
    
    private void atualizarLista(){
        if(count > 0){
            alugueis = aluguelDAO.selecionar();
        }
    }
    
    private boolean novoAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        count++;
        Aluguel aluguel = new Aluguel(
                codigoCliente,
                codigoUnidade, 
                codigoEmpregado,
                (Date) java.util.Date.from(Instant.now()),
                null);
        return aluguelDAO.inserir(aluguel);
    }
    
    private boolean _novoAluguel(int codigoMaterial, String codigoEmpregado, String codigoCliente){
        UnidadeController unidadeController = new UnidadeController();
        
        
        Unidade unidade = Coleccoes.achar(unidadeController.getUnidadesDisponiveis(), (Unidade u) -> {
            return u.getCodigo() == codigoMaterial;
        });
        
        if(unidade == null) return false;
        
        if(novoAluguel(codigoCliente, codigoEmpregado, unidade.getCodigo())){
            
            unidade.setDisponibilidade(Enumeracoes.Disponibilidade.INDISPONIVEL);
            unidadeController.atualizar(unidade);
            unidadeController.alocarNaListaDevida(unidade);
            
            return true;
        }
        
        return false;
    }
    
    public boolean novoAluguel(int CodigoMaterial, String codigoEmpregado, String nomeCliente, String telefoneCliente, String endereco){
       ClienteController clienteController = new ClienteController();
       String codigoCliente = nomeCliente +"_" +telefoneCliente;
       if(!clienteController.existe(codigoCliente)){
           clienteController.inserir(codigoCliente, nomeCliente, telefoneCliente, endereco);
       }
       return _novoAluguel(CodigoMaterial, codigoEmpregado, codigoCliente);
    }
    
    public boolean adicionarDevolucao(int codigoAluguel, Date data_devolucao, EstadoDeConservacao estadoDeConservacao){
        return aluguelDAO.atualizarAluguel(codigoAluguel, data_devolucao, estadoDeConservacao);
    }
    
    public boolean removerAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(codigoCliente, codigoUnidade, codigoEmpregado, null, null);
        return aluguelDAO.remover(aluguel);
    }
}
