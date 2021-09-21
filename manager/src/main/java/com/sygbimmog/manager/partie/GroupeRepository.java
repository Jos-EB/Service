package com.sygbimmog.manager.partie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    Optional<Groupe> findGroupeByNom(String nom);
    Optional<Groupe> findGroupeByContact(String contact);
    Optional<Groupe> findGroupeByEmail(String email);
}
