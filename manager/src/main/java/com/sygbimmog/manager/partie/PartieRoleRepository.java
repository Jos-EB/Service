package com.sygbimmog.manager.partie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartieRoleRepository extends JpaRepository<PartieRole, Long> {
    Optional<PartieRole> findPartieRoleByLabel(String label);
}
