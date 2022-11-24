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
public class Categoria {
    private String codigo;
    private String nome;

    public Categoria(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String representacao = "Categoria{";
        representacao += "codigo: " + codigo + "; "
        + "nome: " + nome + "}";
        return representacao;
    }
}
