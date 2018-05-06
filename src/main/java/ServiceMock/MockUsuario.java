/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceMock;

import Model.Entity.Iuser;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Rafaela Aquino
 */
public class MockUsuario {
      private static final Map<String, Iuser> USUARIOS_CADASTRADOS
	  = new LinkedHashMap<>();

  static {
    USUARIOS_CADASTRADOS.put("admin", new Iuser(USUARIOS_CADASTRADOS.size()+1,
	    "admin", "admin", USUARIOS_CADASTRADOS.size()+1, "admin@admin.com.br", "1/1/1"));
  }
  
  public Iuser buscarPorUsername(String username) {
    return USUARIOS_CADASTRADOS.get(username);
  }
}
