package com.gaag.groupeTrois.Repository;

import com.gaag.groupeTrois.Model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    public Promotion getPromotionByAnnee(LocalDate annee);
}
