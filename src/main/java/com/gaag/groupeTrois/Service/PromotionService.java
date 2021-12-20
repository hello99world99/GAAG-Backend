package com.gaag.groupeTrois.Service;


import com.gaag.groupeTrois.Model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PromotionService {

    List<Promotion> afficherPromotion();
    String supprimerPromotionById(Long id);
    Promotion ajouterPromotion(Promotion promotion);
    Promotion modifierPromotion(Promotion promotion, Long id);
}
