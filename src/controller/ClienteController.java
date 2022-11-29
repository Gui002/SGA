/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.ClienteDAO;
import model.vo.Cliente;
import utilitarios.Coleccoes;

/**
 *
 * @author Fabricio
 */
public class ClienteController {
    private ClienteDAO clienteDAO;
    private static List<Cliente> clientes;
    private static long count = 0;
    private static ClienteController instance;
    
    private ClienteController(){
        clienteDAO = new ClienteDAO();
        count = 1;
        atualizarLista();
    }
    
    public static ClienteController getInstance(){
        if(instance == null){instance = new ClienteController();}
        return instance;
    }
    
    public void atualizarLista(){
        if(count > 0){
            clientes = clienteDAO.selecionar();
        }
    }
    
    public boolean inserir(String codigo, String nome, String telefone, String endereco){
        count ++;
        Cliente cliente = new Cliente(codigo, nome, telefone, endereco);
        return  clienteDAO.inserir(cliente);
    }
    
    public boolean remover(String codigo){
        count++;
        return clienteDAO.remover(new Cliente(codigo, "", "", ""));
    }
    
    public boolean existe(String codigo){
        return Coleccoes.achar(clientes, (Cliente c) -> {return c.getCodigo().equalsIgnoreCase(codigo);}) != null;
    }
    
    public Map<String, Object> getCliente(String codigo){
        Map<String, Object> result = new HashMap();
        
        Cliente cliente = Coleccoes.achar(clientes, (Cliente c) -> {
            return c.getCodigo().equalsIgnoreCase(codigo);
        });
        
        result.put("codigo",   (cliente == null) ? "": cliente.getCodigo());
        result.put("nome",     (cliente == null) ? "": cliente.getNome());
        result.put("telefone", (cliente == null) ? "": cliente.getTelefone());
        result.put("endereco", (cliente == null) ? "": cliente.getEndereco());
        
        return result;
    }
}
