package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        Cliente cliente=manager.find(Cliente.class,1L);
        System.out.println(cliente.getNombre()+" , "+
                "Direcciones: " +cliente.getDirecciones());
        manager.close();
    }
}
