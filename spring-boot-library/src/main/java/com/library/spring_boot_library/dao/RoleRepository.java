package com.library.spring_boot_library.dao;

import com.library.spring_boot_library.model.entity.RoleEntity;
import com.library.spring_boot_library.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRole(RoleEnum role);
}
