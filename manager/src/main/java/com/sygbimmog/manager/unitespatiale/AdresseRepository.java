package com.sygbimmog.manager.unitespatiale;

import com.sygbimmog.manager.partie.PartieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    Optional<Adresse> findAdresseByLabel(String label);
    Optional<Adresse> findAdresseByPays(String pays);
    Optional<Adresse> findAdresseByRegion(String region);
    Optional<Adresse> findAdresseByVille(String ville);
    Optional<Adresse> findAdresseByQuartier(String quartier);
    Optional<Adresse> findAdresseByRue(String rue);
    Optional<Adresse> findAdresseByNumeroBatiment(String numeroBatiement);
    Optional<Adresse> findAdresseByAppartement(String appartement);
}
