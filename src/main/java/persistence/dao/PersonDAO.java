package persistence.dao;

import model.PersonModel;

import java.util.List;

public interface PersonDAO {
    List<PersonModel> getPersons();

    void addPerson(PersonModel model);

    void updatePerson(PersonModel model);

    void deletePerson(Integer id);
}
