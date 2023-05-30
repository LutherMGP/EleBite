package com.elebite.mvc.repository;

import com.elebite.mvc.models.Role;
import com.elebite.mvc.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
