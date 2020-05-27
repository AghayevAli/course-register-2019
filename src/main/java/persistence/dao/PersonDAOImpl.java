package persistence.dao;

import model.DictionaryModel;
import model.PersonModel;
import persistence.entity.Dictionary;
import persistence.entity.Person;
import utility.EntityConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public List<PersonModel> getPersons() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("start");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql = "select p from Person p";
        List<Person> persons = entityManager.createQuery(sql).getResultList();
        List<PersonModel> personModel = new ArrayList<>();
        for (Person person : persons) {
            DictionaryModel dictionary = DictionaryModel.build(person.getType());
            personModel.add(new PersonModel(person.getId(), person.getName(), person.getSurname(), person.getPin(), dictionary));
        }
        return personModel;
    }

    @Override
    public void addPerson(PersonModel model) {
        EntityManager entityManager = EntityConfig.entityOpen("start");

        Person person = new Person();
        person.getPerson(model);

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void updatePerson(PersonModel model) {
        EntityManager entityManager = EntityConfig.entityOpen("start");

        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, model.getId());
        person.setName(model.getName());
        person.setSurname(model.getSurname());
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletePerson(Integer id) {
        EntityManager entityManager = EntityConfig.entityOpen("start");
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
