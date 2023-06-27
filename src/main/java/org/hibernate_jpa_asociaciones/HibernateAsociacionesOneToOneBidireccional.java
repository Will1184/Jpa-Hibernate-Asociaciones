package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.ClienteDetalle;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOneBidireccional {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        try{
            manager.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("paypal");
            manager.persist(cliente);
            ClienteDetalle clienteDetalle= new ClienteDetalle(true,8000L);
            cliente.addDetalle(clienteDetalle);
            manager.persist(cliente);
            manager.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception e){
            manager.close();
            e.printStackTrace();
        }finally {
            manager.close();
        }
    }
}
