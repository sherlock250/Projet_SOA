package tp4.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tp4.entity.Person;
import tp4.util.JpaUtil;

public class PersonDAO {

    // ➕ Add Person
    public void addPerson(Person p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    // 🔍 Get Person by ID
    public Person getPerson(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p;
    }

    // 📋 Get All Persons
    public List<Person> getAllPersons() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Person> query =
                em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> list = query.getResultList();
        em.close();
        return list;
    }

    // ✏️ Update Person
    public void updatePerson(Person p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    // ❌ Delete Person
    public void deletePerson(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
        em.close();
    }
}
