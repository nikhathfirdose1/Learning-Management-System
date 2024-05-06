package com.sjsu.vansbackend.userAuth.repository;

import java.util.Optional;

import com.sjsu.vansbackend.userAuth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByAuthority(String authority);
}
