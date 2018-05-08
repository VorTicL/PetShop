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

    public static void inserirFuncionario(Funcionario funcionario){
        FUNCIONARIOS_CADASTRADOS.add(funcionario);
    }
  
  public static ArrayList buscarPorCpf(String cpf) {
      ArrayList<Funcionario> result = new ArrayList<>();
      for (int i = 0; i < FUNCIONARIOS_CADASTRADOS.size(); i++) {
          if (FUNCIONARIOS_CADASTRADOS.get(i).getCpf().contains(cpf)) {
              result.add(FUNCIONARIOS_CADASTRADOS.get(i));
          }
      }
    return result;
  }
    
  
}
