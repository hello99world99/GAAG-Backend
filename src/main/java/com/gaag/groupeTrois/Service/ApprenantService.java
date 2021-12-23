package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Promotion;

import java.time.LocalDate;
import java.util.List;

interface AprpenantService {
    String ajouterApprenant(Apprenant apprenant);
    List<Apprenant> afficherListApprenant(LocalDate localDate);
    String supprimerApprenantById(Long id);
    Apprenant modifierApprenant(Apprenant apprenant, Long id);
    public List<Apprenant> listApprenantByPromotion(Promotion promotion);
}
