/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.Date;

/**
 *
 * @author victor.rslucca
 */
public class ModelCommercialService extends ModelCommercial{
    
    private String pet;

    public ModelCommercialService(String pet, double valor, String nome, String filial) {
        super(valor, nome, filial);
        this.pet = pet;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }
}
