package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        List<Cliente> clientes= manager.createQuery("SELECT DISTINCT c FROM Cliente c " +
                "LEFT OUTER JOIN FETCH  c.direcciones LEFT OUTER JOIN FETCH c.detalle",Cliente.class).getResultList();
        clientes.forEach(cliente -> System.out.println(cliente.getNombre()+", direcciones: "
                +cliente.getDirecciones()));
    }
}
