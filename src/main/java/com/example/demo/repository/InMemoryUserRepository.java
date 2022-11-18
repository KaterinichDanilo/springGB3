package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserRepository {
  UserRepository userRepository;

  private final Map<Long, User> users = new HashMap<>();

  public InMemoryUserRepository() {
    users.put(1L, createUser(1L, "admin", "admin", List.of("ROLE_ADMIN")));
    users.put(2L, createUser(2L, "user", "user", List.of("ROLE_USER")));

    for (User user : users.values()) {
      userRepository.save(user);
    }
  }

  private User createUser(Long id, String login, String password, List<String> roles) {
    User user = new User();
    user.setId(id);
    user.setLogin(login);
    user.setPassword(password);
    return user;
  }

  public Optional<User> findByLogin(String login) {
    return users.values().stream()
      .filter(it -> Objects.equals(it.getLogin(), login))
      .findFirst();
  }

}
