package controller;

import model.PersonModel;
import org.hibernate.event.spi.MergeEvent;
import persistence.service.PersonService;
import persistence.service.PersonServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index")
public class IndexController {
    private PersonService personService = new PersonServiceImpl();

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<PersonModel> getPersons() {
        return personService.getPersons();
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addPerson(PersonModel model) {
        personService.addPeron(model);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updatePerson(PersonModel model) {
        personService.updatePerson(model);
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePerson(@PathParam("id") Integer id) {
        personService.deletePerson(id);
    }
}
