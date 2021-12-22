package com.gaag.groupeTrois.Repository;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Etat;
import com.gaag.groupeTrois.Model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    List<Apprenant> getApprenantByEtat(Etat etat);
    List<Apprenant> getApprenantByPromotionAndEtat(Promotion promotion, Etat etat);
}
