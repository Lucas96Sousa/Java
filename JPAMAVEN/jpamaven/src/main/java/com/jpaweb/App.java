package com.jpaweb;


import com.jpaweb.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) throws Exception {


        EntityManagerFactory emf ;
        emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = (EntityManager) emf.createEntityManager();

        Person p = em.find(Person.class, 2);
        System.out.println(p);
    }
}
