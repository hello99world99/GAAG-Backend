package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Etat;
import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class ApprenantServiceImpl implements AprpenantService{
    @Autowired
    ApprenantRepository apprenantRepository;
    @Autowired
    PromotionServiceImpl promotionServiceImpl;

    @Override
    public String ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
        System.out.println("Added...");
        return "Apprenant ajouter avec succès...";
    }

    @Override
    public List<Apprenant> afficherListApprenant(LocalDate annee) {
        Promotion promotion = this.promotionServiceImpl.getPromotionByAnnee(annee);
        return apprenantRepository.getApprenantByPromotionAndEtat(promotion, Etat.ACTIVER);
    }

    @Override
    public String supprimerApprenantById(Long id) {
         Apprenant apprenant = apprenantRepository.findById(id).get();
         apprenant.setEtat(Etat.DESACTIVER);
         return "Supprimer avec sucess...";
    }

    @Override
    public Apprenant modifierApprenant(Apprenant apprenant, Long id) {
        Apprenant apprenant_a_modifier = apprenantRepository.findById(id).get();
        apprenant_a_modifier.setNomComplet(apprenant.getNomComplet());
        apprenant_a_modifier.setEmail(apprenant.getEmail());
        apprenant_a_modifier.setTelephone(apprenant.getTelephone());
        apprenant_a_modifier.setPromotion(apprenant.getPromotion());
        return apprenantRepository.save(apprenant_a_modifier);
    }

    @Override
    public List<Apprenant> listApprenantByPromotion(Promotion promotion) {
        return this.apprenantRepository.getApprenantByPromotionAndEtat(promotion, Etat.ACTIVER);
    }
}
