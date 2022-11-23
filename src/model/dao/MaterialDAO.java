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
import model.vo.Material;

/**
 *
 * @author Fabricio
 */
public class MaterialDAO {
    Connection conexao; 
    public MaterialDAO(){
        conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS,USUARIO, "").getConexao();
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
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(codigo));
            preparedStatement.setInt(2, Integer.parseInt(codigo_categoria));
            preparedStatement.setString(3, marca);
            preparedStatement.setString(4, nome);
            preparedStatement.setFloat(5, taxa_diaria);
            preparedStatement.executeUpdate();
            
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
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(codigo_categoria));
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, nome);
            preparedStatement.setFloat(4, taxa_diaria);
            preparedStatement.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
