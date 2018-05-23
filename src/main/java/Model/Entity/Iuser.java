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
public class Iuser {
    
    private int id;
    private String login;
    private String senha;
    private int idFilial;
    private String email;
    private String dataCri;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String rg;
    private String cpf;

    public Iuser(int id, String login, String senha, int idFilial, String email, String dataCri, String nome, String dataNasc, String sexo, String rg, String cpf) {
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
    }

    public Iuser() {
        
    }

    public int getId() {
        return id;
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

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
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
