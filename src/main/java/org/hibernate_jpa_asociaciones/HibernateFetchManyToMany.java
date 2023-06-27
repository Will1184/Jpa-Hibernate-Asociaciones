package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Alumno;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        List<Alumno> alumnos= manager.createQuery("SELECT DISTINCT a FROM Alumno a left " +
                "outer join fetch a.cursos",Alumno.class).getResultList();
        alumnos.forEach(alumno -> System.out.println(alumno.getNombre()+
                ", cursos: "+alumno.getCursos()));
        manager.close();
    }
}
