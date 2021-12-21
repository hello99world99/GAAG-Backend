package com.gaag.groupeTrois.Service;




import com.gaag.groupeTrois.Model.Apprenant;

import java.util.List;


import com.gaag.groupeTrois.Model.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant ajouterApprenant(Apprenant apprenant);
    List<Apprenant> afficherListApprenant();
    String supprimerApprenantById(Apprenant apprenant, Long id);
    Apprenant modifierApprenant(Apprenant apprenant, Long id);

}
