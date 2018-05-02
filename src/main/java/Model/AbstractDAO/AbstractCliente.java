/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Cliente;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractCliente {
    
    public abstract boolean cliente(Cliente cliente);

    public abstract boolean insert(Cliente cliente);

    public abstract List<Cliente> selectAll();

    public abstract Cliente selectId(Cliente cliente);

    public abstract boolean update(Cliente cliente);

    public abstract boolean delete(Cliente cliente);

}
