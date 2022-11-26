/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.Enumeracoes.Disponibilidade;
import controller.Enumeracoes.EstadoDeConservacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import static model.dao.BancoDeDados.*;
import model.vo.Unidade;

/**
 *
 * @author Fabricio
 */
public class UnidadeDAO implements CRUD<Unidade>{
  
    public UnidadeDAO(){
        
    }
    
    @Override
    public boolean inserir(Unidade unidade){
        int codigo_material = unidade.getCodigoMaterial();
        String disponibilidade = unidade.getDisponibilidade().toString();
        String estado = unidade.getEstadoConservacao().toString();
        
        String query = "INSERT INTO Unidade (codigo, codigo_material, disponibilidade, estado_conservacao)"
                + " VALUES (null, ?, ?, ?)";
        
        int linhasAfetadas = 0;
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo_material);
            preparedStatement.setString(2, disponibilidade);
            preparedStatement.setString(3, estado);
          
            linhasAfetadas = preparedStatement.executeUpdate();
            
            conexao.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return linhasAfetadas > 0;
    }
    
    
    @Override
    public boolean remover(Unidade unidade) {
        String query = "DELETE FROM Unidade WHERE codigo = ?";
        int linhasAfetadas = 0;
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            preparedStatement.setInt(1, unidade.getCodigo());
            
            linhasAfetadas = preparedStatement.executeUpdate();
            
            conexao.close();
        } catch (SQLException se) {
            System.out.println("erro ao tentar remover unidade" + se.getMessage());
        }
        
        return linhasAfetadas > 0;
    }

    @Override
    public List<Unidade> selecionar() {
        ArrayList<Unidade> unidades = new ArrayList();
        String query = "SELECT * FROM Unidade";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int codigo = result.getInt("codigo");
                int codigo_material = result.getInt("codigo_material");
                
                Disponibilidade disponibilidade = (result.getString("disponibilidade").equalsIgnoreCase(Disponibilidade.DISPONIVEL.toString())) ? 
                        Disponibilidade.DISPONIVEL : Disponibilidade.INDISPONIVEL;
                
                EstadoDeConservacao estadoDeConservacao = (result.getString("estado_conservacao").equalsIgnoreCase(EstadoDeConservacao.CONSERVADO.toString())) ? 
                        EstadoDeConservacao.CONSERVADO : EstadoDeConservacao.DANIFICADO;
                
                Unidade unidade = new Unidade(codigo, codigo_material, disponibilidade, estadoDeConservacao);
                
                unidades.add(unidade);
            }
            conexao.close();
        } catch (SQLException se) {
            System.out.println("erro ao tentar remover unidade" + se.getMessage());
        }
        
        return unidades;
    }
}
