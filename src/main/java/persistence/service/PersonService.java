package persistence.service;

import model.PersonModel;

import java.util.List;

public interface PersonService {
    public List<PersonModel> getPersons();

    void addPeron(PersonModel model);

    void updatePerson(PersonModel model);

    void deletePerson(Integer id);
}