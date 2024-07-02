package io.github.guilhermendes.imageliteapi.infra.repository;

import io.github.guilhermendes.imageliteapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
