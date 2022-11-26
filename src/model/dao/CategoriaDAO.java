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
import static model.dao.BancoDeDados.*;
import model.vo.Categoria;

/**
 *
 * @author Fabricio
 */
public class CategoriaDAO implements CRUD<Categoria>{
 
    public CategoriaDAO(){
        
    }

    public boolean inserir(Categoria categoria){
        String nome = categoria.getNome();
        String query = "insert into categoria(codigo, nome) values (null, ?)"; 
        int linhasAfetadas = 0;
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            linhasAfetadas = preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return linhasAfetadas > 0;
    }
    
    @Override
    public boolean remover(Categoria categoria) {
        String query = "delete from categoria where codigo = ?";
        int linhasAfetadas = 0;
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();    
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, categoria.getCodigo());
            linhasAfetadas = preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException se){
            System.out.println("erro ao tentar remover categoria: " + se.getMessage());
        }
        
        return linhasAfetadas > 0;
    }

    @Override
    public List<Categoria> selecionar() {
      ArrayList<Categoria> categorias = new ArrayList<>();
      String query = "select * from categoria";
      
      try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();    
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                int codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                Categoria categoria = new Categoria(codigo, nome);
                categorias.add(categoria);
            }
            conexao.close();
      }catch(SQLException se){
          System.out.println("erro ao tentar selecionar categorias: "+se.getMessage());
      }
      return categorias;
    }
}
