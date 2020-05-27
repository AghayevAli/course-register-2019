package persistence.service;

import model.PersonModel;
import persistence.dao.PersonDAO;
import persistence.dao.PersonDAOImpl;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public void updatePerson(PersonModel model) {
        personDAO.updatePerson(model);
    }

    @Override
    public void addPeron(PersonModel model) {
        personDAO.addPerson(model);
    }

    @Override
    public List<PersonModel> getPersons() {
        return personDAO.getPersons();
    }

    @Override
    public void deletePerson(Integer id) {
        personDAO.deletePerson(id);
    }
}
