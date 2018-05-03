/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Servico;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractServico {
    
    public abstract boolean servico(Servico servico);

    public abstract boolean insert(Servico servico);

    public abstract List<Servico> selectAll();

    public abstract Servico selectId(Servico servico);

    public abstract boolean update(Servico servico);

    public abstract boolean delete(Servico servico);

}
