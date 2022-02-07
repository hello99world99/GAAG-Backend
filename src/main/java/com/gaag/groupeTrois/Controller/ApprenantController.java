package com.gaag.groupeTrois.Controller;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Service.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/apprenant")
public class ApprenantController {

    @Autowired
    ApprenantServiceImpl apprenantServiceImp;

    @GetMapping("/list/promo={promo}")
    List<Apprenant> afficherListApprenant(
            @PathVariable("promo") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date
            ){
        return apprenantServiceImp.afficherListApprenant(date);
    }

    @PostMapping("/ajouter")
    String ajouter_apprenant(@RequestBody Apprenant apprenant){
        System.out.println(apprenant);
        return apprenantServiceImp.ajouterApprenant(apprenant);
    }

    @PutMapping("/modifier/{id}")
    Apprenant modifierApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id){
        return apprenantServiceImp.modifierApprenant(apprenant, id);
    }

    @PutMapping("/supprimer/{id}")
    String supprimerApprenant(@PathVariable Long id){
        return apprenantServiceImp.supprimerApprenantById(id);
    }
}
