package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRoleRepository {
  @Autowired
  private RoleRepository roleRepository;

  private final Map<Long, Role> roles = new HashMap<>();

  public InMemoryRoleRepository() {
    roles.put(1L, createRole(1L, "ROLE_ADMIN"));
    roles.put(2L, createRole(2L, "ROLE_USER"));
    for (Role role : roles.values()) {
      roleRepository.save(role);
    }
  }

  private Role createRole(Long id, String name) {
    Role role = new Role();
    role.setId(id);
    role.setName(name);
    return role;
  }

}
