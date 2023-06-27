package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        Cliente cliente= manager.createQuery("SELECT c FROM Cliente c LEFT OUTER  " +
                "JOIN FETCH c.direcciones LEFT JOIN FETCH  c.detalle WHERE  c.id=:id",Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente.getNombre()+", direcciones: "+cliente.getDirecciones());
        System.out.println(cliente.getNombre()+", detalle: "+cliente.getDetalle());
        manager.close();
    }
}
