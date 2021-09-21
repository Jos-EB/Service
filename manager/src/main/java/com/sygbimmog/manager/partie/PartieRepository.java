package com.sygbimmog.manager.partie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartieRepository extends JpaRepository <Partie, Long> {
    Optional<Partie> findPartieByNom(String nom);
    Optional<Partie> findPartieByContact(String contact);
    Optional<Partie> findPartieByEmail(String email);
}
