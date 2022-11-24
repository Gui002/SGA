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
import model.vo.Material;

/**
 *
 * @author Fabricio
 */
public class MaterialDAO implements CRUD<Material>{
 
    public MaterialDAO(){
     
    }
    
    public void inserir(Material material){
        String codigo = material.getCodigo();
        String codigo_categoria = material.getCodigoCategoria();
        String marca = material.getMarca();
        String nome = material.getNome();
        float taxa_diaria = material.getTaxaDiaria();
        
        String query = "insert into material (codigo, codigo_categoria, marca, nome, taxa_diaria)" 
                +" values (?, ?, ?, ?, ?)";
          try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            preparedStatement.setInt(2, Integer.parseInt(codigo_categoria));
            preparedStatement.setString(3, marca);
            preparedStatement.setString(4, nome);
            preparedStatement.setFloat(5, taxa_diaria);
            preparedStatement.executeUpdate();
            System.out.println(conexao);
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void inserirSemCodigo(Material material){
        String codigo_categoria = material.getCodigoCategoria();
        String marca = material.getMarca();
        String nome = material.getNome();
        float taxa_diaria = material.getTaxaDiaria();
        
        String query = "insert into material (codigo_categoria, marca, nome, taxa_diaria)" 
                + " values (?, ?, ?, ?)";
          try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setString(1, codigo_categoria);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, nome);
            preparedStatement.setFloat(4, taxa_diaria);
            preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void remover(Material e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
