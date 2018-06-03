/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author Victor de Lucca
 */
public class ServicosList {
    
    private ModelCommercialService serv;
    private int quantidade;
    private double valorUni;
    
    public ServicosList(){
        
    }

    public ServicosList(ModelCommercialService serv, int quantidade, double valorUni) {
        this.serv = serv;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
    }

    public ModelCommercialService getService() {
        return serv;
    }

    public void setService(ModelCommercialService prod) {
        this.serv = serv;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }
}
