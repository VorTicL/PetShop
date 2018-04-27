/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Iuser;
import java.util.List;

/**
 *
 * @author dev
 */
public abstract class AbstractIuser {
    
    public abstract boolean login(Iuser iuser);

    public abstract boolean insert(Iuser iuser);

    public abstract List<Iuser> selectAll();

    public abstract Iuser selectId(Iuser iuser);

    public abstract boolean update(Iuser iuser);

    public abstract boolean delete(Iuser iuser);

}
