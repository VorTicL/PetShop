/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author João
 */
public class Venda {
    
    private int id;
    private int idcliente;
    private Timestamp dataCri;
    private double valorTotal;
    private List<ItensVenda> itens;
    private List<ServicosList> servList;
    private int filialID;
    
    public Venda(){
        
    }

    public Venda(int id, int idcliente, Timestamp dataCri, int filialID) {
        this.id = id;
        this.idcliente = idcliente;
        this.dataCri = dataCri;
        this.filialID = filialID;
    }

    public int getFilialID() {
        return filialID;
    }

    public void setFilialID(int filialID) {
        this.filialID = filialID;
    }

    public List<ItensVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItensVenda> itens) {
        this.itens = itens;
    }
    
    public double getValorTotal(){
        valorTotal = 0;
        for (int i = 0; i < itens.size(); i++) {
            valorTotal += itens.get(i).getValorUni()*itens.get(i).getQuantidade();
        }
        return valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ServicosList> getServList() {
        return servList;
    }

    public void setServList(List<ServicosList> servList) {
        this.servList = servList;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Timestamp getDataCri() {
        return dataCri;
    }

    public void setDataCri(Timestamp dataCri) {
        this.dataCri = dataCri;
    }
    
}
