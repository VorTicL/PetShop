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
    private int idfuncionario;
    private String email;
    private String dataCri;

    public Iuser(int id, String login, String senha, int idfuncionario, String email, String dataCri) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.idfuncionario = idfuncionario;
        this.email = email;
        this.dataCri = dataCri;
    }

    public Iuser() {
    }

    public int getId() {
        return id;
    }
    
    public boolean validarSenha(String senha){
        return this.senha.compareTo(senha)==0;
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

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
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
    
    
    
}
