/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import static model.dao.BancoDeDados.HOST;
import static model.dao.BancoDeDados.NOME_BANCO_DE_DADOS;
import static model.dao.BancoDeDados.USUARIO;
import model.vo.Cliente;

/**
 *
 * @author Fabricio
 */
public class ClienteDAO implements CRUD<Cliente>{

    @Override
    public boolean inserir(Cliente cliente) {
       String codigo = cliente.getCodigo();
       String nome = cliente.getNome();
       String endereco = cliente.getEndereco();
       String telefone = cliente.getTelefone();
       
       String query = "INSERT INTO Cliente (codigo, nome, endereco, telefone)"
               + "VALUES (?, ?, ?, ?)";   
       
       int linhasAfetadas = 0;
       
       try{
          Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
          PreparedStatement preparedStatement  = conexao.prepareStatement(query);
          
          preparedStatement.setString(1, codigo);
          preparedStatement.setString(2, nome);
          preparedStatement.setString(3, endereco);
          preparedStatement.setString(4, telefone);
          
          linhasAfetadas = preparedStatement.executeUpdate();
          
          conexao.close();
       }catch(SQLException se){
           System.out.println("erro ao tentar inserir cliente: " + se.getMessage());
       }
       return linhasAfetadas > 0;
    }

    @Override
    public boolean remover(Cliente cliente) {
       String query = "DELETE FROM CLIENTE WHERE codigo = ?";
       int linhasAfetadas = 0;
       try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
           PreparedStatement preparedStatement  = conexao.prepareStatement(query);
           preparedStatement.setString(1, cliente.getCodigo());
           linhasAfetadas = preparedStatement.executeUpdate();
           conexao.close();
       } catch (SQLException se) {
           System.out.println("erro ao tentar remover cliente: " + se.getMessage());
        }
       return linhasAfetadas > 0;
    }

    @Override
    public List<Cliente> selecionar() {
        ArrayList<Cliente> clientes = new ArrayList();
        String query = "SELECT * FROM Cliente";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                String codigo = result.getString("codigo");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String endereco = result.getString("endereco");
                
                Cliente cliente = new Cliente(codigo, endereco, nome, telefone);
                
                clientes.add(cliente);
            }
            
            conexao.close();
        } catch (SQLException se) {
            System.out.println("erro ao tentar selecionar os clientes");
        }
        
        return clientes;
    }
    
}
