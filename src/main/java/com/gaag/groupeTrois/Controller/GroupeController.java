package com.gaag.groupeTrois.Controller;


import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Service.GroupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/groupe")
public class GroupeController {


    @Autowired
    GroupeServiceImpl groupeService;


    @GetMapping("/lister")
    List<Groupe> listeGroupe(){

        return groupeService.afficherAllGroupe();
    }

    @PostMapping("/ajouter/{number}")
    void ajouterGroupe(@RequestBody Groupe groupe, @PathVariable int number){


         groupeService.AjouterGroupe(groupe, number);
    }
}
