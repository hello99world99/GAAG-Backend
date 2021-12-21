package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Etat;
import com.gaag.groupeTrois.Repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApprenantServiceImpl implements ApprenantService{
    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public Apprenant ajouterApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> afficherListApprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public String supprimerApprenantById(Apprenant apprenant, Long id) {

        Apprenant apprenantSUp =  apprenantRepository.findById(id).get();
        apprenantSUp.setEtat(Etat.DESACTIVER);

        apprenantRepository.save(apprenantSUp);

         return "Supprimer avec sucess";
    }

    @Override
    public Apprenant modifierApprenant(Apprenant apprenant, Long id) {

        Apprenant apprenant_a_modifier = apprenantRepository.findById(id).get();
        apprenant_a_modifier.setNom_complet(apprenant.getNom_complet());
        apprenant_a_modifier.setEmail(apprenant.getEmail());
        apprenant_a_modifier.setTelephone(apprenant.getTelephone());
        apprenant_a_modifier.setPromotion(apprenant.getPromotion());

        return apprenantRepository.save(apprenant_a_modifier);
    }
}
