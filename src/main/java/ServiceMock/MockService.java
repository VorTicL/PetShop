/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceMock;

import Model.Entity.User;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor de Lucca
 */
public class MockService {
    private static final ArrayList<ModelCommercialService> SERVICE_CADASTRADOS= new ArrayList<>();


    static {
        ModelCommercialService modelCommercialService = new ModelCommercialService("cachorro", 20,
                 "banho", "filial");
        modelCommercialService.setId(1);
        ModelCommercialService modelCommercialService1 = new ModelCommercialService("gato", 30,
                 "banho", "filial");
        modelCommercialService.setId(2);
        SERVICE_CADASTRADOS.add(modelCommercialService);
        SERVICE_CADASTRADOS.add(modelCommercialService1);
    }

    public static void inserirProduto(ModelCommercialService service) {
        service.setId(SERVICE_CADASTRADOS.get(SERVICE_CADASTRADOS.size() - 1).getId() + 1);
        SERVICE_CADASTRADOS.add(service);
    }

    public static ArrayList buscarPorUsername(String nome) {
        ArrayList<ModelCommercialService> result = new ArrayList<>();
        for (int i = 0; i < SERVICE_CADASTRADOS.size(); i++) {
            if (SERVICE_CADASTRADOS.get(i).getNome().contains(nome)) {
                result.add(SERVICE_CADASTRADOS.get(i));
            }
        }
        return result;
    }

    public static void remover(int id) {
        for (int i = 0; i < SERVICE_CADASTRADOS.size(); i++) {
            if (SERVICE_CADASTRADOS.get(i).getId() == id) {
                SERVICE_CADASTRADOS.remove(SERVICE_CADASTRADOS.get(i));
                return;
            }
        }
    }

    public static void alterar(ModelCommercialService modelCommercialService) {
        for (int i = 0; i < SERVICE_CADASTRADOS.size(); i++) {
            if (SERVICE_CADASTRADOS.get(i).getId() == modelCommercialService.getId()) {
                SERVICE_CADASTRADOS.remove(SERVICE_CADASTRADOS.get(i));
                SERVICE_CADASTRADOS.add(modelCommercialService);
                return;
            }
        }
    }

    public static ModelCommercialService buscarPorId(int id) {
        ModelCommercialService modelCommercialService = null;
        for (int i = 0; i < SERVICE_CADASTRADOS.size(); i++) {
            if (SERVICE_CADASTRADOS.get(i).getId() == id) {
                modelCommercialService = SERVICE_CADASTRADOS.get(i);
                return modelCommercialService;
            }
        }
        return modelCommercialService;
    }

    public static ModelCommercialService buscarPorNome(String nome) {
        ModelCommercialService result1 = null;
        for (int i = 0; i < SERVICE_CADASTRADOS.size(); i++) {
            if (SERVICE_CADASTRADOS.get(i).getNome().equalsIgnoreCase(nome)) {
                result1 = SERVICE_CADASTRADOS.get(i);
                return result1;
            }

        }
        return result1;
    }
}
