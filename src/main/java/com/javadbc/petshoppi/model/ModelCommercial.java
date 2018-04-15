/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadbc.petshoppi.model;

import java.util.Date;

/**
 *
 * @author victor.rslucca
 */
abstract class ModelCommercial {
    protected double valorUni;
    protected String nome;
    protected String nomeUser;
    protected String filial;
    protected int qtdContract;

    protected Date dataContract;

    public ModelCommercial(double valorUni, String nome, int qtdContract, Date dataContract) {
        this.valorUni = valorUni;
        this.nome = nome;
        this.qtdContract = qtdContract;
        this.dataContract = dataContract;
    }
    
    
    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public Date getDataContract() {
        return dataContract;
    }

    public void setDataContract(Date dataContract) {
        this.dataContract = dataContract;
    }

    public double getValor() {
        return valorUni;
    }

    public void setValor(double valorUni) {
        this.valorUni = valorUni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdContract() {
        return qtdContract;
    }

    public void setQtdContract(int qtdContract) {
        this.qtdContract = qtdContract;
    }
    
    public abstract double calculaTotal();
    
}
