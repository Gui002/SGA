/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.Disponibilidade;
import controller.Enumeracoes.EstadoDeConservacao;
import model.dao.UnidadeDAO;
import model.vo.Unidade;

/**
 *
 * @author Fabricio
 */
public class UnidadeController {
    UnidadeDAO unidadeDAO;
    public UnidadeController(){
        unidadeDAO = new UnidadeDAO();
    }
    
    public boolean inserir(int codigo, int codigoMaterial, Disponibilidade disponibilidade, EstadoDeConservacao estadaConservacao){
        Unidade unidade = new Unidade(codigo, codigoMaterial, disponibilidade, estadaConservacao);
        return unidadeDAO.inserir(unidade);
    }
    
    public boolean remover(int codigo){
        return unidadeDAO.remover(new Unidade(codigo, 0, Disponibilidade.DISPONIVEL, EstadoDeConservacao.CONSERVADO));
    }
}
