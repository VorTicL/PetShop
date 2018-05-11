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
 * @author Victor de Lucca
 */
public class MockProduto {
    private static final ArrayList<ModelCommercialProduct> PRODUTOS_CADASTRADOS= new ArrayList<>();


    static {
        ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct("victor", 20,
                 "senac", 20);
        modelCommercialProduct.setId(1);
        ModelCommercialProduct modelCommercialProduct1 = new ModelCommercialProduct("victorr", 30,
                 "senac1", 30);
        modelCommercialProduct.setId(2);
        PRODUTOS_CADASTRADOS.add(modelCommercialProduct);
        PRODUTOS_CADASTRADOS.add(modelCommercialProduct1);
    }

    public static void inserirProduto(ModelCommercialProduct product) {
        product.setId(PRODUTOS_CADASTRADOS.get(PRODUTOS_CADASTRADOS.size() - 1).getId() + 1);
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

    public static void remover(int id) {
        for (int i = 0; i < PRODUTOS_CADASTRADOS.size(); i++) {
            if (PRODUTOS_CADASTRADOS.get(i).getId() == id) {
                PRODUTOS_CADASTRADOS.remove(PRODUTOS_CADASTRADOS.get(i));
                return;
            }
        }
    }

    public static void alterar(ModelCommercialProduct modelCommercialProduct) {
        for (int i = 0; i < PRODUTOS_CADASTRADOS.size(); i++) {
            if (PRODUTOS_CADASTRADOS.get(i).getId() == modelCommercialProduct.getId()) {
                PRODUTOS_CADASTRADOS.remove(PRODUTOS_CADASTRADOS.get(i));
                PRODUTOS_CADASTRADOS.add(modelCommercialProduct);
                return;
            }
        }
    }

    public static ModelCommercialProduct buscarPorId(int id) {
        ModelCommercialProduct modelCommercialProduct = null;
        for (int i = 0; i < PRODUTOS_CADASTRADOS.size(); i++) {
            if (PRODUTOS_CADASTRADOS.get(i).getId() == id) {
                modelCommercialProduct = PRODUTOS_CADASTRADOS.get(i);
                return modelCommercialProduct;
            }
        }
        return modelCommercialProduct;
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
