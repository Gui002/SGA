/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author Fabricio
 */
public class Cliente {
     private String codigo;
     private String endereco;
     private String nome;
     private String telefone;

    public Cliente(String codigo, String nome, String telefone, String endereco) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        String representacao = "Cliente{";
        representacao += "codigo: " + codigo + "; "
                + "nome: " + nome +";"
                + "telefone: " + telefone + "; "
                + "endereco: " + endereco + "}";
        return representacao;
    }
     
}
