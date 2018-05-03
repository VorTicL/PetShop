/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Endereco;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractEndereco {
    
    public abstract boolean endereco(Endereco endereco);

    public abstract boolean insert(Endereco endereco);

    public abstract List<Endereco> selectAll();

    public abstract Endereco selectId(Endereco endereco);

    public abstract boolean update(Endereco endereco);

    public abstract boolean delete(Endereco endereco);

}
