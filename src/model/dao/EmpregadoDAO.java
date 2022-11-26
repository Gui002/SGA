/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.Enumeracoes.Sexo;
import controller.Enumeracoes.TipoDeEmpregado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import static model.dao.BancoDeDados.HOST;
import static model.dao.BancoDeDados.NOME_BANCO_DE_DADOS;
import static model.dao.BancoDeDados.USUARIO;
import model.vo.Empregado;

/**
 *
 * @author Fabricio
 */
public class EmpregadoDAO implements CRUD<Empregado>{

    @Override
    public void inserir(Empregado empregado) {
        String codigo = empregado.getCodigo();
        String nome = empregado.getNome();
        String senha = empregado.getSenha();
        String telefone = empregado.getSenha();
        String endereco = empregado.getEndereco();
        Sexo sexo = empregado.getSexo();
        TipoDeEmpregado tipo = empregado.getTipo();
        
        String query = "INSERT INTO Empregado (codigo, nome, sexo, senha, telefone, endereco, tipo)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, sexo.toString());
            preparedStatement.setString(4, senha);
            preparedStatement.setString(5, telefone);
            preparedStatement.setString(6, endereco);
            preparedStatement.setString(7, tipo.toString());
            
            preparedStatement.executeUpdate();
            
            conexao.close();
        } catch (SQLException se) {
            System.out.println("Erro ao tentar inserir empregado: " + se);
        }
    }

    @Override
    public void remover(Empregado empregado) {
        String query = "DELETE FROM CLIENTE WHERE codigo = ?";
        try{
           Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
           PreparedStatement preparedStatement  = conexao.prepareStatement(query);
           preparedStatement.setString(1, empregado.getCodigo());
           preparedStatement.executeUpdate();
           conexao.close();
        }catch (SQLException se) {
           System.out.println("erro ao tentar remover cliente: " + se.getMessage());
        }
    }

    @Override
    public List<Empregado> selecionar() {
        ArrayList<Empregado> empregados = new ArrayList(); 
        String query = "SELECT * FROM EMPREGADO";
        
        try{
            Connection conexao = new Conexao(HOST, NOME_BANCO_DE_DADOS, USUARIO, "").getConexao();  
            PreparedStatement preparedStatement  = conexao.prepareStatement(query);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                String codigo = result.getString("codigo");
                String nome = result.getString("nome");
                String senha = result.getString("senha");
                String telefone = result.getString("telefone");
                String endereco = result.getString("endereco");
                Sexo sexo = result.getString("sexo").equalsIgnoreCase(Sexo.F.toString()) ? Sexo.F: Sexo.M;
                TipoDeEmpregado tipo = result.getString("tipo").equalsIgnoreCase(TipoDeEmpregado.ATENDENTE.toString()) ?
                        TipoDeEmpregado.ATENDENTE : TipoDeEmpregado.GERENTE;
                
                Empregado empregado = new Empregado(codigo, endereco, nome, senha, sexo, telefone, tipo);
                
                empregados.add(empregado);
            }
            
            conexao.close();
        }catch(SQLException se){
            System.out.println("Erro ao tentar selecionar clientes");
        }
        
        return empregados;
    }
    
}
