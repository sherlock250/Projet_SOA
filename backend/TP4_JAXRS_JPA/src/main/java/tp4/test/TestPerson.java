package tp4.test;

import javax.persistence.EntityManager;
import tp4.entity.Person;
import tp4.util.JpaUtil;

public class TestPerson {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Person p = new Person("Ali", "Ben Salah", 25);
        em.persist(p);

        em.getTransaction().commit();
        em.close();

        System.out.println("Person ajoutée avec succès !");
    }
}
