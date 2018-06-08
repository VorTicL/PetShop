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
public class ItensVenda {
    
    private ModelCommercialProduct produto;
    private int quantidade;
    private double valorUni;
    
    public ItensVenda(){
        
    }

    public ItensVenda(ModelCommercialProduct produto, int quantidade, double valorUni) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
    }

    public ModelCommercialProduct getProduto() {
        return produto;
    }

    public void setProduto(ModelCommercialProduct produto) {
        this.produto = produto;
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
