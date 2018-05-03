/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AbstractDAO;

import Model.Entity.Animal;
import java.util.List;

/**
 *
 * @author João
 */
public abstract class AbstractAnimal {
    
    public abstract boolean animal(Animal animal);

    public abstract boolean insert(Animal animal);

    public abstract List<Animal> selectAll();

    public abstract Animal selectId(Animal animal);

    public abstract boolean update(Animal animal);

    public abstract boolean delete(Animal animal);

}
