package com.gaag.groupeTrois.Service;

<<<<<<< HEAD
public interface AprpenantService {

=======
import com.gaag.groupeTrois.Model.Apprenant;

import java.util.List;

public interface AprpenantService {
    Apprenant ajouterApprenant(Apprenant apprenant);
    List<Apprenant> afficherListApprenant();
    String supprimerApprenantById(Long id);
    Apprenant modifierApprenant(Apprenant apprenant, Long id);
>>>>>>> 2acfbcd53d0bccf9cc1d81787df2453c87690e84
}
