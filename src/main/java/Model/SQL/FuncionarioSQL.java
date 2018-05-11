/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Entity.Funcionario;

/**
 *
 * @author João
 */
public class FuncionarioSQL {
    public int insert(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {

         String sql = "insert into funcionario (nome,dataNasc,sexo,rg,cpf,idendereco,dataCri) values (?,?,?,?,?,?,date(now()))";


        pst = conexao.prepareStatement(sql);

        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getDataNasc());
        pst.setString(3, funcionario.getSexo());
        pst.setString(4, funcionario.getRg());
        pst.setString(5, funcionario.getCpf());
        pst.setInt(6, funcionario.getIdendereco());
        pst.execute();
        
        ResultSet rs = selectFuncionario(conexao, pst, funcionario);

        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
        
    }

    public void update(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {

        String sql = "update funcionario set nome = ? and dataNasc = ? and  sexo = ? and cpf = ? and idendereco = ? where id = ? and ativo = true";

        pst = conexao.prepareStatement(sql);

        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getDataNasc());
        pst.setString(3, funcionario.getSexo());
        pst.setString(4, funcionario.getRg());
        pst.setString(5, funcionario.getCpf());
        pst.setInt(6, funcionario.getIdendereco());
        pst.setInt(7, funcionario.getId());
        
        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {
        String sql = "select id,nome,dataNasc,sexo,rg,cpf,idendereco,dataCri from funcionario where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);

        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {
        String sql = "select id,nome,dataNasc,sexo,rg,cpf,idendereco,dataCri from funcionario where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, funcionario.getId());

        return pst.executeQuery();
    }

    public void delete(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {
        String sql = "update funcionario set ativo = false where id = ?";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, funcionario.getId());

        pst.execute();
    }
    
    public ResultSet selectFuncionario(Connection conexao, PreparedStatement pst, Funcionario funcionario) throws SQLException {
        String sql = "select id from funcionario where nome = ? and datanasc = ? and sexo = ? and rg = ? and cpf = ? and idendereco = ? and ativo = true";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getDataNasc());
        pst.setString(3, funcionario.getSexo());
        pst.setString(4, funcionario.getRg());
        pst.setString(5, funcionario.getCpf());
        
        return pst.executeQuery();
    }
}
