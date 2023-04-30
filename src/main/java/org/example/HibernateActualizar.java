package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.Cliente;
import org.example.utilities.JpaUtil;

import javax.swing.*;
import java.util.Scanner;

public class HibernateActualizar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println("Cambie el nombre del cliente " + cliente.getNombre() + " por: ");
        String nombre = s.next();
        System.out.println("Cambie el apellido del cliente " + cliente.getApellido() + " por: ");
        String apellido = s.next();
        System.out.println("Cambie el método de pago " + cliente.getFormaPago() + " del cliente por: ");
        String pago = s.next();
        try {
            em.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}
