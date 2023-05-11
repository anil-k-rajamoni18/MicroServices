package com.codealien.user.repository;

import com.codealien.user.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<Person, Long> {
    Person findByUserId(Long userId);
}
