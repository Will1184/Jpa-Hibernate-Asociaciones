package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        try{
            manager.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("paypal");
            Factura factura = new Factura("Compras de supermercado",5000L);
            Factura factura1 = new Factura("Compras de supermercado",7000L);

            cliente.addFactura(factura)
                    .addFactura(factura1);

            manager.persist(cliente);
            manager.getTransaction().commit();
            System.out.println(cliente);
            manager.getTransaction().begin();

            //Factura f3 = manager.find(Factura,class,1L);
            Factura factura2 = new Factura("compras de supermercado",5000L);
            factura2.setId(1L);
            cliente.removeFactura(factura2);
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
