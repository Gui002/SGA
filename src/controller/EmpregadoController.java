/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Enumeracoes.Sexo;
import controller.Enumeracoes.TipoDeEmpregado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.EmpregadoDAO;
import model.vo.Empregado;
import utilitarios.Coleccoes;

/**
 *
 * @author Fabricio
 */
public class EmpregadoController {
    private EmpregadoDAO empregadoDAO;
    private static List<Empregado> empregados;
    private static long count = 0;
    
    public EmpregadoController(){
        empregadoDAO = new EmpregadoDAO();
        count = 1;
        atualizar();
    }
    
    private void atualizar(){
        if(count > 0){
            empregados = empregadoDAO.selecionar();
            count = 0;
        }
    }
    
    public boolean inserir(String codigo, String nome, Sexo sexo, String telefone, String endereco, String senha, TipoDeEmpregado tipo){
        count ++;
        Empregado empregado = new Empregado(codigo, endereco, nome, senha, sexo, telefone, tipo);
        return empregadoDAO.inserir(empregado);
    }
    
    public boolean remover(String codigo){
        count++;
        return empregadoDAO.remover(new Empregado(codigo, "", "", "", Sexo.M, "", TipoDeEmpregado.ATENDENTE));//Somente o codigo interessa
    }
    
    public List<String> getCodigos(){
        atualizar();
        List<String> codigos = new ArrayList();
        empregados.forEach((empregado) -> {
            codigos.add(empregado.getCodigo());
        });
        
        return codigos;
    }
    
    public Map<String, Object> getEmpregado(String codigo){
        Map<String, Object> result = new HashMap();
        Empregado empregado = Coleccoes.achar(empregados, (Empregado e) -> {
            return e.getCodigo().equalsIgnoreCase(codigo);
        });
        
        result.put("codigo",   (empregado == null) ? "": empregado.getCodigo());
        result.put("nome",     (empregado == null) ? "": empregado.getNome());
        result.put("sexo",     (empregado == null) ? "": empregado.getSexo());
        result.put("senha",    (empregado == null) ? "": empregado.getSenha());
        result.put("telefone", (empregado == null) ? "": empregado.getTelefone());
        result.put("endereco", (empregado == null) ? "": empregado.getEndereco());
        result.put("tipo",     (empregado == null) ? "": empregado.getTipo());
        
        return result;
    }
}
