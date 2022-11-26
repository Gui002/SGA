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
import model.vo.Material;

/**
 *
 * @author Fabricio
 */
public class MaterialDAO implements CRUD<Material>{
 
    public MaterialDAO(){
     
    }
    
    public boolean inserir(Material material){
        int codigo_categoria = material.getCodigoCategoria();
        String marca = material.getMarca();
        String nome = material.getNome();
        float taxa_diaria = material.getTaxaDiaria();
        
        String query = "INSERT INTO MATERIAL (codigo, codigo_categoria, marca, nome, taxa_diaria)" 
                +" VALUES (null, ?, ?, ?, ?)";
        
        int linhasAfetadas = 0;
          try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
        
            preparedStatement.setInt(1, codigo_categoria);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, nome);
            preparedStatement.setFloat(4, taxa_diaria);
            linhasAfetadas = preparedStatement.executeUpdate();
            System.out.println(conexao);
            conexao.close();
        }catch(SQLException se){
            System.out.println("erro ao tenter inserir material" + se.getMessage());
        }
          
       return linhasAfetadas > 0;   
    }
    

    @Override
    public boolean remover(Material material) {
        String query = "DELETE FROM MATERIAL WHERE codigo = ?";
        int linhasAfetadas = 0;
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();    
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, material.getCodigo());
            linhasAfetadas = preparedStatement.executeUpdate();
            conexao.close();
        }catch(SQLException se){
            System.out.println("erro ao tentar remover material: " + se.getMessage());
        }
        
        return linhasAfetadas > 0;
    }

    @Override
    public List<Material> selecionar() {
        ArrayList<Material> materiais = new ArrayList();
        String query = "SELECT * FROM MATERIAL";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int codigo = result.getInt("codigo");
                int codigo_categoria = result.getInt("codigo_categoria");
                String nome = result.getString("nome");
                String marca = result.getString("marca");
                float taxa_diaria = result.getFloat("taxa_diaria");
                
                Material material = new Material(codigo, codigo_categoria, marca, nome, taxa_diaria);
                materiais.add(material);
            }
            
            conexao.close();
        } catch (SQLException se) {
            System.out.println("Erro ao tentar selecionar materiais" + se.getMessage());
        }
        
        return materiais;
    }
}
