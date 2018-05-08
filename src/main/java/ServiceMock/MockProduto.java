/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceMock;

import Model.Entity.Iuser;
import Model.Entity.ModelCommercialProduct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rafaela Aquino
 */
public class MockProduto {
    private static final ArrayList<ModelCommercialProduct> PRODUTOS_CADASTRADOS= new ArrayList<>();

    public static void inserirProduto(ModelCommercialProduct product){
        PRODUTOS_CADASTRADOS.add(product);
    }
  
  public static ArrayList buscarPorUsername(String nome) {
      ArrayList<ModelCommercialProduct> result = new ArrayList<>();
      for (int i = 0; i < PRODUTOS_CADASTRADOS.size(); i++) {
          if (PRODUTOS_CADASTRADOS.get(i).getNome().contains(nome)) {
              result.add(PRODUTOS_CADASTRADOS.get(i));
          }
      }
    return result;
  }
    public static ModelCommercialProduct buscarPorNome(String nome) {
      ModelCommercialProduct result1 = null;
      for (int i = 0; i < PRODUTOS_CADASTRADOS.size(); i++) {
          if (PRODUTOS_CADASTRADOS.get(i).getNome().equalsIgnoreCase(nome)) {
              result1 = PRODUTOS_CADASTRADOS.get(i);
              return result1;
          }
          
      }
    return result1;
  }
}
