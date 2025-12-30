package tp4.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import tp4.dao.PersonDAO;
import tp4.entity.Person;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private PersonDAO dao = new PersonDAO();

    // GET http://localhost:8080/TP4_JAXRS_JPA/api/persons
    @GET
    public List<Person> getAllPersons() {
        return dao.getAllPersons();
    }

    // GET http://localhost:8080/TP4_JAXRS_JPA/api/persons/1
    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam("id") int id) {
        return dao.getPerson(id);
    }

    // POST http://localhost:8080/TP4_JAXRS_JPA/api/persons
    @POST
    public void addPerson(Person p) {
        dao.addPerson(p);
    }

    // PUT http://localhost:8080/TP4_JAXRS_JPA/api/persons
    @PUT
    public void updatePerson(Person p) {
        dao.updatePerson(p);
    }

    // DELETE http://localhost:8080/TP4_JAXRS_JPA/api/persons/1
    @DELETE
    @Path("/{id}")
    public void deletePerson(@PathParam("id") int id) {
        dao.deletePerson(id);
    }
}
