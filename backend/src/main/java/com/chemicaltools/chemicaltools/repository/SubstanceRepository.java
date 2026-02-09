package com.chemicaltools.chemicaltools.repository;

import com.chemicaltools.chemicaltools.model.entity.Substance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
* Repository that extends the CRUD operations thanks to
 * SpringBoot from JpaRepository.In this case, SELECT will be applied.
 */
@Repository
public interface SubstanceRepository extends JpaRepository<Substance, String> {
    Optional<Substance> findByName(String name);
    Optional<Substance> findByFormula(String formula);
}
