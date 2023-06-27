package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.ClienteDetalle;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOneFind {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        try{
            manager.getTransaction().begin();
            Cliente cliente = manager.find(Cliente.class,2L);
            ClienteDetalle clienteDetalle= new ClienteDetalle(true,8000L);
            manager.persist(clienteDetalle);
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
