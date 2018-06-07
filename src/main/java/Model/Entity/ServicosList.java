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
    
    private ModelCommercialService servico;
    private int quantidade;
    private double valorUni;
    
    public ServicosList(){
        
    }

    public ServicosList(ModelCommercialService servico, int quantidade, double valorUni) {
        this.servico = servico;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
    }

    public ModelCommercialService getServico() {
        return servico;
    }

    public void setServico(ModelCommercialService servico) {
        this.servico = servico;
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
