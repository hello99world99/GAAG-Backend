package com.gaag.groupeTrois.Service;


import com.gaag.groupeTrois.Model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PromotionService {

    List<Promotion> afficherPromotion();
    String supprimerPromotionById(Long id);
    String ajouterPromotion(Promotion promotion);
    String modifierPromotion(Promotion promotion, Long id);
}
