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
public class ModelCommercialProduct extends ModelCommercial{
    private int qtdProd;

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public ModelCommercialProduct(int qtdProd, double valorUni, String nome, int qtdContract, Date dataContract) {
        super(valorUni, nome, qtdContract, dataContract);
        this.qtdProd = qtdProd;
    }
    
    @Override
    public double calculaTotal(){
        return qtdContract*valorUni;
    }
}
