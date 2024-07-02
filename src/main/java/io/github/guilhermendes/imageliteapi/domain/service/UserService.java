package io.github.guilhermendes.imageliteapi.domain.service;

import io.github.guilhermendes.imageliteapi.domain.AccessToken;
import io.github.guilhermendes.imageliteapi.domain.entity.User;

public interface UserService {
    User getByEmail(String email);
    User save(User user);
    AccessToken autheticate(String email, String password);
}
