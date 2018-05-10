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
public class ModelCommercial {
    protected double valor;
    protected String nome;
    protected String filial;
    protected int id;

    public ModelCommercial(double valor, String nome, String filial) {
        this.nome = nome;
        this.valor = valor;
        this.filial = filial;
    }
    
    public ModelCommercial(){
        
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
