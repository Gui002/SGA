/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;
import controller.Enumeracoes.*;
/**
 *
 * @author Fabricio
 */
public class Empregado {
   private String codigo;
   private String endereco; 
   private String nome;
   private String senha;    
   private Sexo sexo;
   private String Telefone;
   private TipoDeEmpregado tipo;

    public Empregado(String codigo, String endereco, String nome, String senha, Sexo sexo, String Telefone, TipoDeEmpregado tipo) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.nome = nome;
        this.senha = senha;
        this.sexo = sexo;
        this.Telefone = Telefone;
        this.tipo = tipo;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public TipoDeEmpregado getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeEmpregado tipo) {
        this.tipo = tipo;
    }
   
   
}
