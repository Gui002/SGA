/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import controller.Enumeracoes;
import controller.Enumeracoes.EstadoDeConservacao;
import java.sql.Date;

/**
 *
 * @author Fabricio
 */
public class Aluguel {
    private int codigoUnidade;
    private String codigoCliente, codigoEmpregado; 
    private Date data_aluguel, data_devolucao;
    private EstadoDeConservacao estado_conservacao;

    public Aluguel(int codigoUnidade, String codigoCliente, String codigoEmpregado, Date data_aluguel, Date data_devolucao, EstadoDeConservacao estado_conservacao) {
        this.codigoUnidade = codigoUnidade;
        this.codigoCliente = codigoCliente;
        this.codigoEmpregado = codigoEmpregado;
        this.data_aluguel = data_aluguel;
        this.data_devolucao = data_devolucao;
        this.estado_conservacao = estado_conservacao;
    }

    public EstadoDeConservacao getEstado_conservacao() {
        return estado_conservacao;
    }

    public void setEstado_conservacao(EstadoDeConservacao estado_conservacao) {
        this.estado_conservacao = estado_conservacao;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(int codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public String getCodigoEmpregado() {
        return codigoEmpregado;
    }

    public void setCodigoEmpregado(String codigoEmpregado) {
        this.codigoEmpregado = codigoEmpregado;
    }

    public Date getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(Date data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Override
    public String toString() {
        String representacao = "Aluguel{";
        representacao += "codigo do cliente" + codigoCliente + "; "
                + "codigo do empregado" +codigoEmpregado + "; "
                + "codigo da unidade" +codigoUnidade + "; "
                + "data de aluguel" + data_aluguel + "; "
                + "data de devolucao" + data_devolucao + "}";
        
        return representacao;
    }
  
}
