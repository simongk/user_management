package com.simongk.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Szymon on 2017-02-13.
 */
@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id",scope=UserGroup.class)
public class UserGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;



    @ManyToMany
    @JsonIdentityReference
    private List<User> users;
}
