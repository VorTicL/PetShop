/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.util.Date;

/**
 *
 * @author victor.rslucca
 */
public class ModelCommercialProduct extends ModelCommercial{

    private int qtdProd;
    
    public ModelCommercialProduct(String nome, double valor, int filial, int qtdProd) {
        super(valor, nome, filial);
        this.qtdProd = qtdProd;
    }
    
    public ModelCommercialProduct(){
        
    }
    
    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }
}
