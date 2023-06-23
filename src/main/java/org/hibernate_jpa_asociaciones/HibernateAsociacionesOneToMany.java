package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Direccion;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        try{
            manager.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("mercado pago");

            Direccion d1= new Direccion("El vergel",123);
            Direccion d2= new Direccion("Vasco De Gama",456);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            manager.persist(cliente);
            manager.getTransaction().commit();
            System.out.println(cliente);
            manager.getTransaction().begin();
            cliente = manager.find(Cliente.class,cliente.getId());
            cliente.getDirecciones().remove(d1);
            manager.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }
}
