package com.sygbimmog.manager.partie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeTypeRepository extends JpaRepository<GroupeType, Long> {
    java.util.Optional<GroupeType> findGroupeTypeByLabel(String label);
}
