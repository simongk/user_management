package com.simongk.repositories;

import com.simongk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Szymon on 2017-02-13.
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
