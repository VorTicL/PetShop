/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.sql.Timestamp;

/**
 *
 * @author João
 */
public class Filial {
    
    private int idFilial;
    private String nome;
    private Timestamp dataCri;
    private String endereco;
    private int numero;
    
    public Filial(){
        
    }

    public Filial(int idFilial, String nome, Timestamp dataCri, String endereco, int numero) {
        this.idFilial = idFilial;
        this.nome = nome;
        this.dataCri = dataCri;
        this.endereco = endereco;
        this.numero = numero;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataCri() {
        return dataCri;
    }

    public void setDataCri(Timestamp dataCri) {
        this.dataCri = dataCri;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
