package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{

    @Autowired
    PromotionRepository promotionRepository;


    @Override
    public List<Promotion> afficherPromotion() {
        return promotionRepository.findAll();
    }

    @Override
    public String supprimerPromotionById(Long id) {
        promotionRepository.deleteById(id);
        return "Promotion supprimer avec succes";
    }

    @Override
    public String ajouterPromotion(Promotion promotion) {
        promotionRepository.save(promotion);
        return "Promotion ajoutée avec succèss...";
    }

    @Override
    public String modifierPromotion(Promotion promotion, Long id) {
        Promotion promo_a_modifier = promotionRepository.findById(id).get();
        promo_a_modifier.setAnnee(promotion.getAnnee());
        promo_a_modifier.setFormation(promotion.getFormation());
        promotionRepository.save(promo_a_modifier);
        return "Promotion modifiée avec succèss...";
    }

    @Override
    public Promotion getPromotionByAnnee(LocalDate anneee) {
        return this.promotionRepository.getPromotionByAnnee(anneee);
    }
}
