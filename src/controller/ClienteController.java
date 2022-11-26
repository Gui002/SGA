/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.ClienteDAO;
import model.vo.Cliente;

/**
 *
 * @author Fabricio
 */
public class ClienteController {
    private ClienteDAO clienteDAO;
    
    public ClienteController(){
        clienteDAO = new ClienteDAO();
    }
    
    public boolean inserir(String codigo, String nome, String telefone, String endereco){
        Cliente cliente = new Cliente(codigo, nome, telefone, endereco);
        return  clienteDAO.inserir(cliente);
    }
    
    public boolean remover(String codigo){
        return clienteDAO.remover(new Cliente(codigo, "", "", ""));
    }
    
}
