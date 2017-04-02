package com.simongk.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Szymon on 2017-02-13.
 */
@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id", scope=User.class)
public class User{

    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    @ManyToMany(mappedBy = "users")
    @JsonIdentityReference
    private List<UserGroup> groups;

}
