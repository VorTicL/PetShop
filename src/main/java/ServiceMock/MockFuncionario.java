/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceMock;

import Model.Entity.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author João
 */
public class MockFuncionario {
    private static final ArrayList<Funcionario> FUNCIONARIOS_CADASTRADOS= new ArrayList<>();

    static {
        Funcionario func = new Funcionario(1,2,"victor", "20/05/18",
                 "masculino", "5555555","55555555","5/06/17");
         func.setId(1);
         func.setIdendereco(1);
        Funcionario  func1 = new Funcionario(1,2,"luiz", "20/05/18",
                 "masculino", "5555555","55555555","5/06/17");
         func.setId(2);
        FUNCIONARIOS_CADASTRADOS.add( func);
        FUNCIONARIOS_CADASTRADOS.add( func1);
    }
    public static void inserirFuncionario(Funcionario funcionario){
        FUNCIONARIOS_CADASTRADOS.add(funcionario);
    }
  
  public static ArrayList buscarPorNome(String nome) {
      ArrayList<Funcionario> result = new ArrayList<>();
      for (int i = 0; i < FUNCIONARIOS_CADASTRADOS.size(); i++) {
          if (FUNCIONARIOS_CADASTRADOS.get(i).getCpf().contains(nome)) {
              result.add(FUNCIONARIOS_CADASTRADOS.get(i));
          }
      }
    return result;
  }
   public static void alterar(Funcionario func) {
      for (int i = 0; i < FUNCIONARIOS_CADASTRADOS.size(); i++) {
          if (FUNCIONARIOS_CADASTRADOS.get(i).getId() == func.getId()) {
              FUNCIONARIOS_CADASTRADOS.remove(FUNCIONARIOS_CADASTRADOS.get(i));
              FUNCIONARIOS_CADASTRADOS.add(func);
              return;
          }
      }
  }
   public static void remover(int id) {
      for (int i = 0; i < FUNCIONARIOS_CADASTRADOS.size(); i++) {
          if (FUNCIONARIOS_CADASTRADOS.get(i).getId() == id) {
              FUNCIONARIOS_CADASTRADOS.remove(FUNCIONARIOS_CADASTRADOS.get(i));
              return;
          }
      }
  }
    public static Funcionario buscarPorId(int id) {
        Funcionario funcionario = null;
        for (int i = 0; i < FUNCIONARIOS_CADASTRADOS.size(); i++) {
            if (FUNCIONARIOS_CADASTRADOS.get(i).getId() == id) {
                funcionario = FUNCIONARIOS_CADASTRADOS.get(i);
                return funcionario;
            }
        }
        return funcionario;
    }
    
  
}
