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
public class Servico {
    
    private int id;
    private String nome;
    private double preco;
    private int animal;
    private String dataCri;
    
    public Servico(){
        
    }

    public Servico(int id, String nome, double preco, int animal, String dataCri) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.animal = animal;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }
        
}
