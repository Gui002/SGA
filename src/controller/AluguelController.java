/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.EstadoDeConservacao;
import java.time.Instant;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.AluguelDAO;
import model.vo.Aluguel;
import model.vo.Unidade;
import utilitarios.Coleccoes;


/**
 *
 * @author Fabricio
 */
public class AluguelController {
    private AluguelDAO aluguelDAO;
    private static List<Aluguel> alugueis;
    private static List<Map<String, String>> codigos;
    private static long count = 0;
    
    public AluguelController(){
        aluguelDAO = new AluguelDAO();
        count = 1;
        atualizarLista();
    }
    
    private void atualizarLista(){
        if(count > 0){
            alugueis = aluguelDAO.selecionar();
            
            alugueis.forEach((aluguel) -> {
                Map <String, String> map = new HashMap();
                map.put("codigoEmpregado", aluguel.getCodigoEmpregado());
                map.put("codigoCliente", aluguel.getCodigoCliente());
                map.put("codigoUnidade", aluguel.getCodigoUnidade() + "");
                codigos.add(map);
            });
            
        }
    }
    
    public Map<String, Object> getAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Map<String, Object> result = new HashMap();
        
        Aluguel aluguel = Coleccoes.achar(alugueis, (Aluguel a) -> {
            return a.getCodigoCliente().equalsIgnoreCase(codigoCliente) &&
                    a.getCodigoEmpregado().equalsIgnoreCase(codigoEmpregado) &&
                    a.getCodigoUnidade() == codigoUnidade;
        });
        
        result.put("codigo_cliente",     (aluguel == null)? "":aluguel.getCodigoCliente());
        result.put("codigo_empregado",   (aluguel == null)? "":aluguel.getCodigoEmpregado());
        result.put("codigo_unidade",     (aluguel == null)? "":aluguel.getCodigoUnidade());
        result.put("data_inicio",        (aluguel == null)? "":aluguel.getData_aluguel());
        result.put("data_devolucao",     (aluguel == null)? "":aluguel.getData_devolucao());
        result.put("estado_conservacao", (aluguel == null)? "":aluguel.getEstado_conservacao());
        
        return result;
    }
    
    
    private boolean novoAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        count++;
        Aluguel aluguel = new Aluguel(
                codigoUnidade, 
                codigoCliente, 
                codigoEmpregado, 
                (Date) java.util.Date.from(Instant.now()), 
                null, 
                null
        );
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
        Aluguel aluguel = new Aluguel(codigoUnidade, codigoCliente, codigoEmpregado, null, null, EstadoDeConservacao.CONSERVADO);
        return aluguelDAO.remover(aluguel);
    }
}
