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
    Connection conexao;
    
    public Conexao(String host, String nomeDoBD,String usuario, String senha){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://" + host + "/" + nomeDoBD , usuario, senha);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexao() {
        return conexao;
    }
 
}
