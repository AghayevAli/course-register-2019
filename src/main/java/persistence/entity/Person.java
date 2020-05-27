package persistence.entity;

import model.PersonModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pin")
    private String pin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private Dictionary type;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void getPerson(PersonModel model) {
        this.name = model.getName();
        this.surname = model.getSurname();
        this.pin = model.getPin();
    }

    public Dictionary getType() {
        return type;
    }

    public void setType(Dictionary type) {
        this.type = type;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}