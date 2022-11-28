/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.Disponibilidade;
import controller.Enumeracoes.EstadoDeConservacao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.UnidadeDAO;
import model.vo.Unidade;
import utilitarios.Coleccoes;

/**
 *
 * @author Fabricio
 */
public class UnidadeController {
    UnidadeDAO unidadeDAO;
    private static List<Unidade> unidades;
    private static List<Unidade> unidadesDisponiveis;
    private List<Unidade> unidadesIndisponiveis;
    private static long count = 0;
    
    
    public UnidadeController(){
        unidadeDAO = new UnidadeDAO();
        count = 1;
        atualizarLista();
    }
    
    public void atualizarLista(){
        if(count > 0){
            unidades = unidadeDAO.selecionar();
            unidades.forEach((unidade) -> {
                if(unidade.getDisponibilidade().toString().equalsIgnoreCase(Disponibilidade.DISPONIVEL.toString())){
                    unidadesDisponiveis.add(unidade);
                }else{
                    unidadesIndisponiveis.add(unidade);
                }
            });
        }
    }
    
    public boolean atualizar(Unidade unidade){
        count++;
        return unidadeDAO.atualizar(unidade);
    }
    
    public boolean inserir(int codigo, int codigoMaterial, Disponibilidade disponibilidade, EstadoDeConservacao estadaConservacao){
        count++;
        Unidade unidade = new Unidade(codigo, codigoMaterial, disponibilidade, estadaConservacao);
        return unidadeDAO.inserir(unidade);
    }
    
    public boolean remover(int codigo){
        count++;
        return unidadeDAO.remover(new Unidade(codigo, 0, Disponibilidade.DISPONIVEL, EstadoDeConservacao.CONSERVADO));
    }
    
    public List<Unidade> getUnidades(){
        return unidades;
    }
    
    public List<Unidade> getUnidadesDisponiveis(){
        return unidadesDisponiveis;
    }
    
    public List<Unidade> getUnidadesIndiponiveis(){
        return unidadesIndisponiveis;
    }
    
    public Map<String, Object> getUnidade(int codigo){
        Map<String, Object> result = new HashMap();
        
        Unidade unidade = Coleccoes.achar(unidades, (Unidade u) -> {
           return u.getCodigo() == codigo;
        });
        
        result.put("codigo",             (unidade == null)? "":unidade.getCodigo());
        result.put("disponibilidade",    (unidade == null)? "":unidade.getDisponibilidade());
        result.put("estado_conservacao", (unidade == null)? "":unidade.getEstadoConservacao());
        result.put("codigo_material",    (unidade == null)? "":unidade.getCodigoMaterial());
        
        
        return result;
    }
    
    public void alocarNaListaDevida(Unidade unidade){
        if(unidades.contains(unidade)){
            if(unidade.getDisponibilidade().toString().equalsIgnoreCase(Disponibilidade.DISPONIVEL.toString())){
                unidadesDisponiveis.remove(unidade); //So para evitar duplicatas (remover se exister)
                unidadesDisponiveis.add(unidade); //(Reinserir, nesta caso sem duplicata)
                unidadesIndisponiveis.remove(unidade);
            }else{
                unidadesIndisponiveis.remove(unidade); //So para evitar duplicatas (remover se exister)
                unidadesIndisponiveis.add(unidade); //(Reinserir, nesta caso sem duplicata)
                unidadesDisponiveis.remove(unidade);
            }
        }
    }
    
}
