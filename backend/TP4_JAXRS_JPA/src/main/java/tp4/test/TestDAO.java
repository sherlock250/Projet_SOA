package tp4.test;

import java.util.List;
import tp4.dao.PersonDAO;
import tp4.entity.Person;

public class TestDAO {

    public static void main(String[] args) {

        PersonDAO dao = new PersonDAO();

        // ADD
        Person p1 = new Person("Mohamed", "Ali", 30);
        dao.addPerson(p1);

        // GET ALL
        List<Person> persons = dao.getAllPersons();
        System.out.println("Liste des personnes :");
        for (Person p : persons) {
            System.out.println(p.getId() + " - " + p.getNom());
        }

        // GET ONE
        Person p = dao.getPerson(p1.getId());
        System.out.println("Person trouvée : " + p.getNom());

        // UPDATE
        p.setAge(35);
        dao.updatePerson(p);

        // DELETE
        dao.deletePerson(p.getId());

        System.out.println("CRUD terminé avec succès !");
    }
}
