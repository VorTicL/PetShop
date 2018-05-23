/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author João
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String rg;
    private String cpf;
    private String dataCri;
    
    public Cliente(){
        
    }

    public Cliente(int id, String nome, String dataNasc, String sexo, String rg, String cpf, String dataCri) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataCri = dataCri;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the datanasc
     */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the datanasc to set
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the datacri
     */
    public String getDataCri() {
        return dataCri;
    }

    /**
     * @param dataCri the datacri to set
     */
    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }
    
}
