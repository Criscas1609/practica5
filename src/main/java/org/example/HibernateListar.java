package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.Cliente;
import org.example.utilities.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c",
                Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}

