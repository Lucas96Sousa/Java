package com.jpaweb;


import com.jpaweb.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com");
        Person p2 = new Person(null, "Joaquim Phoenix", "joaquim@gmail.com");
        Person p3 = new Person(null, "Javier Barden", "javier@gmail.com");

        EntityManagerFactory emf ;
        emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = (EntityManager) emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        System.out.println("Finish");
    }
}
