package dto;

import java.util.List;

public class StudentDTO {
    private int id;
    private int rowId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int phoneNumber;
    private String gender;
    private ComboDTO combo;
    private RoleDTO role;
    private List<RoleDTO> roles;

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public StudentDTO(int id, int rowId, String name, String surname, String email, int phoneNumber, ComboDTO combo) {
        this.id = id;
        this.rowId = rowId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.combo = combo;
    }

    public StudentDTO(int id, int rowId, String name, String surname, String email, int phoneNumber, ComboDTO combo, String password) {
        this.id = id;
        this.rowId = rowId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.combo = combo;
        this.password = password;
    }

    public StudentDTO(int id, int rowId, String name, String surname, String email, RoleDTO role) {
        this.id = id;
        this.rowId = rowId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }

    public StudentDTO(int id, String name, String surname, String email, int phoneNumber, String gender, ComboDTO combo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.combo = combo;
    }

    public StudentDTO(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public StudentDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ComboDTO getCombo() {
        return combo;
    }

    public void setCombo(ComboDTO combo) {
        this.combo = combo;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
