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
public class Animal {
    
    private int id;
    private String nome;
    private String raca;
    private String dataCri;
    
    public Animal(){
        
    }

    public Animal(int id, String nome, String raca, String dataCri) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.dataCri = dataCri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }
    
    
}
