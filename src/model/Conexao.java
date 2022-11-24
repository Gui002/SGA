/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabricio
 */
public class Conexao {
    String host;
    String nomeDoBD;
    String usuario;
    String senha;
    Connection conexao = null;
    
    public Conexao(String host, String nomeDoBD,String usuario, String senha){
        this.host = host;
        this.nomeDoBD = nomeDoBD;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection getConexao() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://" + host + "/" + nomeDoBD, usuario, senha);
        }catch(ClassNotFoundException ce){
            System.out.println(ce.getMessage());
        }
        
        
        if(conexao == null){throw new SQLException("a conexao nao foi estabelecida!");}
        
        return conexao;
    }
 
}
