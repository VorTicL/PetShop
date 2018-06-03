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
    protected int filial;
    protected int id;

    public ModelCommercial(double valor, String nome, int filial) {
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

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
