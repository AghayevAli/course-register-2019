package model;

public class PersonModel {

    private Integer id;
    private String name;
    private String surname;
    private String pin;
    private DictionaryModel type;

    public PersonModel(Integer id, String name, String surname, String pin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pin = pin;
    }

    public PersonModel(Integer id, String name, String surname, String pin, DictionaryModel type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pin = pin;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PersonModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public PersonModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DictionaryModel getType() {
        return type;
    }

    public void setType(DictionaryModel type) {
        this.type = type;
    }

    public PersonModel() {
    }
}
