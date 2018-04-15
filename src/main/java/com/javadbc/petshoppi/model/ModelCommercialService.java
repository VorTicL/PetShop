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
public class ModelCommercialService extends ModelCommercial{
    
    public ModelCommercialService(double valorUni, String nome, int qtdContract, Date dataContract) {
        super(valorUni, nome, qtdContract, dataContract);
    }
    
    @Override
    public double calculaTotal(){
        return qtdContract*valorUni;
    }
}
