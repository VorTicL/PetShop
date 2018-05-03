/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractFuncionario;
import Model.Connect.Connect;
import Model.Entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class FuncionarioDAO extends AbstractFuncionario{

 private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;    
    
    
    @Override
    public boolean insert(Funcionario funcionario) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into funcionario(nome,dataNasc,sexo,rg,cpf,idendereco,dataCri)");
            sql.append(" values (?,?,?,?,?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getDataNasc());
            pst.setString(3, funcionario.getSexo());
            pst.setString(5, funcionario.getRg());
            pst.setString(5, funcionario.getCpf());
            pst.setInt(5, funcionario.getIdendereco());
            
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
    public List<Funcionario> selectAll() {

        ArrayList<Funcionario> funcionario = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,idendereco,dataCri");
            sql.append(" from funcionario and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                funcionario.add(new Funcionario(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }

            return funcionario;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return funcionario;
        }

    }
    @Override
    public Funcionario selectId(Funcionario funcionario) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,idendereco,dataCri");
            sql.append(" from funcionario where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, funcionario.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                funcionario.setNome(rs.getString(2));
                funcionario.setDataNasc(rs.getString(3));
                funcionario.setSexo(rs.getString(4));
                funcionario.setRg(rs.getString(5));
                funcionario.setCpf(rs.getString(6));
                funcionario.setIdendereco(rs.getInt(7));
                funcionario.setDataCri(rs.getString(8));
            }

            return funcionario;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return funcionario;
        }
    }
     @Override
        public boolean update(Funcionario funcionario) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update funcionario set nome = ? , dataNasc = ? , sexo = ? , rg = ? , cpf = ? , idendereco = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getDataNasc());
            pst.setString(3, funcionario.getSexo());
            pst.setString(4, funcionario.getRg());
            pst.setString(5, funcionario.getCpf());
            pst.setInt(6, funcionario.getIdendereco());
            pst.setInt(7, funcionario.getId());

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
    public boolean delete(Funcionario funcionario) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update funcionario set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, funcionario.getId());

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
    public boolean funcionario(Funcionario funcionario) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,idendereco,dataCri");
            sql.append(" from funcionario where nome = ? and dataNasc = ? and sexo = ? and rg = ? and cpf = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getDataNasc());
            pst.setString(3, funcionario.getSexo());
            pst.setString(4, funcionario.getRg());
            pst.setString(5, funcionario.getCpf());

            rs = pst.executeQuery();
            
            if(rs.next()){
                funcionario.setId(rs.getInt(1));
                funcionario.setIdendereco(rs.getInt(7));
                funcionario.setDataCri(rs.getString(8));
            
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
