package ru.tasktracler.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tasktracler.userservice.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
