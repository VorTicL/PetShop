/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Venda;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractVenda {
    
    public abstract boolean venda(Venda venda);

    public abstract boolean insert(Venda venda);

    public abstract List<Venda> selectAll();

    public abstract Venda selectId(Venda venda);

    public abstract boolean update(Venda venda);

    public abstract boolean delete(Venda venda);

}
