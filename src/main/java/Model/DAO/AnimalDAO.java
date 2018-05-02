/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractAnimal;
import Model.Entity.Animal;
import Model.Connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class AnimalDAO {
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    @Override
    public boolean insert(Animal animal) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into animal(nome,raca,dataCri)");
            sql.append(" values (?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, animal.getNome());
            pst.setString(2, animal.getRaca());

            pst.execute();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }

    }
    
    @Override
    public List<Animal> selectAll() {

        ArrayList<Animal> animal = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,raca,dataCri");
            sql.append(" from animal and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                animal.add(new Animal(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

            return animal;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return animal;
        }

    }
    
    @Override
    public Animal selectId(Animal animal) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,raca,dataCri");
            sql.append(" from animal where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, animal.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                animal.setNome(rs.getString(2));
                animal.setRaca(rs.getString(3));
                animal.setDataCri(rs.getString(4));
               
            }

            return animal;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return animal;
        }
    }
    
    @Override
    public boolean update(Animal animal) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update animal set nome = ? , raca = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, animal.getNome());
            pst.setString(2, animal.getRaca());
            pst.setInt(3, animal.getId());
           

            pst.executeUpdate();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }
    
     @Override
    public boolean delete(Animal animal) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update iuser set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, animal.getId());

            pst.execute();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }
   @Override
    public boolean animal(Animal animal) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,raca,dataCri");
            sql.append(" from iuser where nome = ? and raca = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, animal.getNome());
            pst.setString(2, animal.getRaca());

            rs = pst.executeQuery();
            
            if(rs.next()){
                animal.setId(rs.getInt(1));
                animal.setDataCri(rs.getString(4));
                
                return true;
            }

            return false;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }
    
}
