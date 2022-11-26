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
    private int codigo;
    private int codigoCategoria;
    private String marca;
    private String nome;
    private float taxaDiaria;

    public Material(int codigo, int codigoCategoria, String marca, String nome, float taxaDiaria) {
        this.codigo = codigo;
        this.codigoCategoria = codigoCategoria;
        this.marca = marca;
        this.nome = nome;
        this.taxaDiaria = taxaDiaria;
    }
    
    public Material(int codigoCategoria, String marca, String nome, float taxaDiaria) {
        this.codigoCategoria = codigoCategoria;
        this.marca = marca;
        this.nome = nome;
        this.taxaDiaria = taxaDiaria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
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
