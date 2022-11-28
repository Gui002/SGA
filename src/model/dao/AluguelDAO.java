/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.Enumeracoes;
import controller.Enumeracoes.EstadoDeConservacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import static model.dao.BancoDeDados.HOST;
import static model.dao.BancoDeDados.NOME_BANCO_DE_DADOS;
import static model.dao.BancoDeDados.USUARIO;
import model.vo.Aluguel;

/**
 *
 * @author Fabricio
 */
public class AluguelDAO implements CRUD<Aluguel>{

    @Override
    public boolean inserir(Aluguel aluguel) {
        String codigoCliente = aluguel.getCodigoCliente();
        String codigoEmpregado = aluguel.getCodigoEmpregado();
        int codigoUnidade = aluguel.getCodigoUnidade();
        Date data_inicio = aluguel.getData_aluguel();
        String estado_conservacao = aluguel.getEstado_conservacao().toString();
        int linhasAfetadas = 0;
        
        String query = "INSERT INTO Aluguel"
                + " (codigo_cliente, codigo_unidade, codigo_empregado, data_inicio, estado_conservacao)"
                + " VALUES (?, ?, ?, ?, ?)";
        
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           
           preparedStatement.setString(1, codigoCliente);
           preparedStatement.setInt(2, codigoUnidade);
           preparedStatement.setString(3, codigoEmpregado);
           preparedStatement.setDate(4, data_inicio);
           preparedStatement.setString(5, estado_conservacao);
           
           linhasAfetadas = preparedStatement.executeUpdate();
           
           conexao.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        
        return linhasAfetadas > 0;
    }

    @Override
    public boolean remover(Aluguel e) {
        String query = "DELETE FROM Aluguel WHERE codigo_cliente = ?"
                + "AND codigo_unidade = ? AND codigo_empregado = ?";
        
        int linhasAfetadas = 0;
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           preparedStatement.setString(1, e.getCodigoCliente());
           preparedStatement.setInt(2, e.getCodigoUnidade());
           preparedStatement.setString(3, e.getCodigoEmpregado());
           
           linhasAfetadas = preparedStatement.executeUpdate();
           
           conexao.close();
        }catch(SQLException se){
            System.out.println("erro ao tentar remover aluguel");
        }
        
        return linhasAfetadas > 0;
    }
    
    
    public boolean atualizarAluguel(int codigoAluguel, Date data_devolucao, EstadoDeConservacao estadoDeConservacao){
        String query = "UPDATE Aluguel set data_devolucao = ?, estado_conservacao = ? WHERE codigo = ?";
        int linhasAfetadas = 0;
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           
           preparedStatement.setDate(1, data_devolucao);
           preparedStatement.setString(2, estadoDeConservacao.toString());
           preparedStatement.setInt(3, codigoAluguel);
           
           linhasAfetadas = preparedStatement.executeUpdate();
           
           conexao.close();
           
        }catch(SQLException se){
            System.out.println("erro ao atualizar aluguel: " + se.getSQLState());
        }
        
        return linhasAfetadas > 0;
    }

    @Override
    public List<Aluguel> selecionar() {
        ArrayList<Aluguel> alugueis = new ArrayList();
        String query = "SELECT * FROM ALUGUEL";
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           
           ResultSet result = preparedStatement.executeQuery();
           
           while(result.next()){
               String codigoCliente = result.getString("codigo_cliente");
               int codigoUnidade = result.getInt("codigo_unidade");
               String codigoEmpregado = result.getString("codigo_empregado");
               Date data_aluguel = result.getDate("data_inicio");
               Date data_devolucao = result.getDate("data_devolucao");
               EstadoDeConservacao estado_conservacao = result.getString("estado_conservacao")
                       .equalsIgnoreCase(EstadoDeConservacao.CONSERVADO.toString())? EstadoDeConservacao.CONSERVADO: EstadoDeConservacao.DANIFICADO;
               
               Aluguel aluguel = new Aluguel(codigoUnidade, codigoCliente, codigoEmpregado, data_aluguel, data_devolucao, estado_conservacao);
            
               alugueis.add(aluguel);
               
               conexao.close();
           }
           
           conexao.close();
        }catch(SQLException se){
            System.out.println("Erro ao tentar selecionar alugueis");
        }
        
        return alugueis;
    }
    
}
