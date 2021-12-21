package com.gaag.groupeTrois.Controller;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Service.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/apprenant")
public class ApprenantController {

    @Autowired
    ApprenantServiceImpl apprenantServiceImp;

    @GetMapping("/afficher")
    List<Apprenant> afficherListApprenant(){
        return apprenantServiceImp.afficherListApprenant();
    }

    @PostMapping("/ajouter")
    Apprenant ajouter_apprenant(@RequestBody  Apprenant apprenant){
        return apprenantServiceImp.ajouterApprenant(apprenant);
    }

    @PutMapping("/modifier/{id}")
    Apprenant modifierApprenant(@RequestBody Apprenant apprenant,@PathVariable Long id){

        return apprenantServiceImp.modifierApprenant(apprenant, id);
    }

    @DeleteMapping("/supprimer/{id}")
    String supprimerApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id){

        return apprenantServiceImp.supprimerApprenantById(apprenant, id);


    }


}
