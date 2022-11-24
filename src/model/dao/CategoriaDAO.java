/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Conexao;
import static model.dao.BancoDeDados.*;
import model.vo.Categoria;

/**
 *
 * @author Fabricio
 */
public class CategoriaDAO implements CRUD<Categoria>{
 
    public CategoriaDAO(){
        
    }

    public void inserir(Categoria categoria){
        String codigo = categoria.getCodigo();
        String nome = categoria.getNome();
        String query = "insert into categoria(codigo, nome) values (?, ?)"; 
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, nome);
            preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void inserirSemCodigo(Categoria categoria){
        String nome = categoria.getNome();
        String query = "insert into categoria( nome) values (?)"; 
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();    
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void remover(Categoria e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
