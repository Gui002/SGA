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
import model.vo.Unidade;

/**
 *
 * @author Fabricio
 */
public class UnidadeDAO {
  
    public UnidadeDAO(){
        
    }
    
    public void inserir(Unidade unidade){
        String codigo = unidade.getCodigo();
        String codigo_material = unidade.getCodigoMaterial();
        String disponibilidade = unidade.getDisponibilidade().toString();
        String estado = unidade.getEstadoConservacao().toString();
        
        String query = "insert into Unidade values(codigo, codigo_material, disponibilidade, estado_conservacao)"
                + " values (?, ?, ?, ?)";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(codigo));
            preparedStatement.setInt(2, Integer.parseInt(codigo_material));
            preparedStatement.setString(3, disponibilidade);
            preparedStatement.setString(4, estado);
          
            preparedStatement.executeUpdate();
            
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
     public void inserirSemCodigo(Unidade unidade){
        String codigo_material = unidade.getCodigoMaterial();
        String disponibilidade = unidade.getDisponibilidade().toString();
        String estado = unidade.getEstadoConservacao().toString();
        
        String query = "insert into Unidade values(codigo_material, disponibilidade, estado_conservacao)"
                + " values (?, ?, ?)";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(codigo_material));
            preparedStatement.setString(2, disponibilidade);
            preparedStatement.setString(3, estado);
            
            preparedStatement.executeUpdate();
            
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
