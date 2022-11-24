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
public class Material {
    private String codigo;
    private String codigoCategoria;
    private String marca;
    private String nome;
    private float taxaDiaria;

    public Material(String codigo, String codigoCategoria, String marca, String nome, float taxaDiaria) {
        this.codigo = codigo;
        this.codigoCategoria = codigoCategoria;
        this.marca = marca;
        this.nome = nome;
        this.taxaDiaria = taxaDiaria;
    }
    
    public Material(String codigoCategoria, String marca, String nome, float taxaDiaria) {
        this.codigoCategoria = codigoCategoria;
        this.marca = marca;
        this.nome = nome;
        this.taxaDiaria = taxaDiaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTaxaDiaria() {
        return taxaDiaria;
    }

    public void setTaxaDiaria(float taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    @Override
    public String toString() {
        String representacao = "Material{";
        representacao += "codigo: " + codigo + "; "
                + "nome: " + nome + "; "
                + "marca: " + marca + "; "
                + "codigo da categoria" + codigoCategoria + "}";
        return representacao;
    }
    
}
