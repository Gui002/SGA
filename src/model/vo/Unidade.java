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
public class Unidade {
    private String codigo;
    private String codigoMaterial;
    private Disponibilidade disponibilidade;
    private EstadoDeConservacao estadoConservacao;

    public Unidade(String codigo, String codigoMaterial, Disponibilidade disponibilidade, EstadoDeConservacao estadoConservacao) {
        this.codigo = codigo;
        this.codigoMaterial = codigoMaterial;
        this.disponibilidade = disponibilidade;
        this.estadoConservacao = estadoConservacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public EstadoDeConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoDeConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    @Override
    public String toString() {
        String representacao = "Unidade{";
        representacao += "codigo: " + codigo + "; "
                + "disponibilidade: " + disponibilidade.toString() + "; "
                + "estado de conservacao: " + estadoConservacao.toString() + "; "
                + "codigo do material: " + codigoMaterial + "}";
        
        return representacao;
    }
    
}
