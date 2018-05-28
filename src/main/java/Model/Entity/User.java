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
public class User {
    
    private int id;
    private String login;
    private String senha;
    private int idFilial;
    private String email;
    private Timestamp dataCri;
    private String nome;
    private Timestamp dataNasc;
    private String sexo;
    private String rg;
    private String cpf;
    private String typeUser;
    private String sobrenome; 

    public User(int id, String login, String senha, int idFilial, String email, Timestamp dataCri, 
            String nome, Timestamp dataNasc, String sexo, String rg, String cpf, String typeUser, String sobrenome) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.idFilial = idFilial;
        this.email = email;
        this.dataCri = dataCri;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.typeUser = typeUser;
        this.sobrenome = sobrenome;
    }

    public User() {
        
    }

    public int getId() {
        return id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getType() {
        return typeUser;
    }

    public void setType(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDataCri() {
        return dataCri;
    }

    public void setDataCri(Timestamp dataCri) {
        this.dataCri = dataCri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Timestamp dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
