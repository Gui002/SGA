/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

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
    public void inserir(Aluguel aluguel) {
        String codigoCliente = aluguel.getCodigoCliente();
        String codigoEmpregado = aluguel.getCodigoEmpregado();
        String codigoUnidade = aluguel.getCodigoUnidade();
        Date data_inicio = aluguel.getData_aluguel();
        Date data_devolucao = aluguel.getData_devolucao();
        
        String query = "INSERT INTO Aluguel"
                + " (codigo_cliente, codigo_unidade, codigo_empregado, data_inicio, data_devolucao)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           
           preparedStatement.setString(1, codigoCliente);
           preparedStatement.setString(2, codigoUnidade);
           preparedStatement.setString(3, codigoEmpregado);
           preparedStatement.setDate(4, data_inicio);
           preparedStatement.setDate(5, data_devolucao);
           
           preparedStatement.executeUpdate();
           
           conexao.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
    }

    @Override
    public void remover(Aluguel e) {
        String query = "REMOVE FROM Aluguel WHERE codigo_cliente = ?"
                + "AND codigo_unidade = ? AND codigo_empregado = ?";
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();
           PreparedStatement preparedStatement = conexao.prepareStatement(query);
           preparedStatement.setString(1, e.getCodigoCliente());
           preparedStatement.setString(2, e.getCodigoUnidade());
           preparedStatement.setString(3, e.getCodigoEmpregado());
           
           preparedStatement.executeUpdate();
           
           conexao.close();
        }catch(SQLException se){
            System.out.println("erro ao tentar remover aluguel");
        }
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
               String codigoUnidade = result.getString("codigo_unidade");
               String codigoEmpregado = result.getString("codigo_empregado");
               Date data_aluguel = result.getDate("data_inicio");
               Date data_devolucao = result.getDate("data_devolucao");
               
               Aluguel aluguel = new Aluguel(codigoCliente, codigoUnidade, codigoEmpregado, data_aluguel, data_devolucao);
            
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
