/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.Sexo;
import controller.Enumeracoes.TipoDeEmpregado;
import model.dao.EmpregadoDAO;
import model.vo.Empregado;

/**
 *
 * @author Fabricio
 */
public class EmpregadoController {
    private EmpregadoDAO empregadoDAO;
    public EmpregadoController(){
        empregadoDAO = new EmpregadoDAO();
    }
    
    public boolean inserir(String codigo, String nome, Sexo sexo, String telefone, String endereco, String senha, TipoDeEmpregado tipo){
        Empregado empregado = new Empregado(codigo, endereco, nome, senha, sexo, telefone, tipo);
        return empregadoDAO.inserir(empregado);
    }
    
    public boolean remover(String codigo){
        return empregadoDAO.remover(new Empregado(codigo, "", "", "", Sexo.M, "", TipoDeEmpregado.ATENDENTE));//Somente o codigo interessa
    }
}
