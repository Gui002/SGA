/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Date;

/**
 *
 * @author Fabricio
 */
public class Aluguel {
     private String codigoCliente, codigoUnidade, codigoEmpregado;
    private Date data_aluguel, data_devolucao;

    public Aluguel(String codigoCliente, String codigoUnidade, String codigoEmpregado, Date data_aluguel, Date data_devolucao) {
        this.codigoCliente = codigoCliente;
        this.codigoUnidade = codigoUnidade;
        this.codigoEmpregado = codigoEmpregado;
        this.data_aluguel = data_aluguel;
        this.data_devolucao = data_devolucao;
    }

   

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(String codigoUnidade) {
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
