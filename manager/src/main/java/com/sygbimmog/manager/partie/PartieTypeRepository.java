package com.sygbimmog.manager.partie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartieTypeRepository extends JpaRepository<PartieType, Long> {
    Optional<PartieType> findPartieTypeByLabel(String label);
}
