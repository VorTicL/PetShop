/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Funcionario;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractFuncionario {
    
    public abstract boolean funcionario(Funcionario funcionario);

    public abstract boolean insert(Funcionario funcionario);

    public abstract List<Funcionario> selectAll();

    public abstract Funcionario selectId(Funcionario funcionario);

    public abstract boolean update(Funcionario funcionario);

    public abstract boolean delete(Funcionario funcionario);

}
