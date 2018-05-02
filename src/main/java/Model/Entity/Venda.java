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
public class Venda {
    
    private int id;
    private int idservico;
    private int idcliente;
    private String dataCri;
    
    public Venda(){
        
    }

    public Venda(int id, int idservico, int idcliente, String dataCri) {
        this.id = id;
        this.idservico = idservico;
        this.idcliente = idcliente;
        this.dataCri = dataCri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdservico() {
        return idservico;
    }

    public void setIdservico(int idservico) {
        this.idservico = idservico;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }
    
}
