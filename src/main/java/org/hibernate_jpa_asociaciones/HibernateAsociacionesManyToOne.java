package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesManyToOne {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("credito");
            manager.persist(cliente);
            Factura factura = new Factura("compras de oficina",1000L);
            factura.setCliente(cliente);
            manager.persist(factura);
            System.out.println(factura.getCliente());
            System.out.println(factura);
            manager.getTransaction().commit();

        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            manager.close();
        }
    }
}
