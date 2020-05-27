package persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private Integer id;

    private String name;

}
