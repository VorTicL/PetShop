/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadbc.petshoppi.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author João
 */
public class ModelCommercialCliente {
    
    private String nome;
    private Date dataNascimento;
    private String genero;
    private String tel;
    private String email;

   
    
    public ModelCommercialCliente(String nome, String dataNascimentoT) {
    this.nome = nome;
    DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.dataNascimento = formatador.parse(dataNascimentoT);
    } catch (ParseException e) {

    }
  }
    public ModelCommercialCliente(String nome, String dataNascimentoT, String genero, String tel,String email ){
      this(nome, dataNascimentoT);
      this.genero = genero;
      this.tel = tel;
      this.email = email;
    }
    
    
    
     public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
