/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Conexao;
import static model.dao.BancoDeDados.*;
import model.vo.Categoria;

/**
 *
 * @author Fabricio
 */
public class CategoriaDAO {
    Connection conexao;
    public CategoriaDAO(){
        conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
    }

    public void inserir(Categoria categoria){
        String codigo = categoria.getCodigo();
        String nome = categoria.getNome();
        String query = "insert into categoria(codigo, nome) values (?, ?)"; 
        
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(codigo));
            preparedStatement.setString(2, nome);
            preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void inserirSemCodigo(Categoria categoria){
        String nome = categoria.getNome();
        String query = "insert into categoria( nome) values (?)"; 
        
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
