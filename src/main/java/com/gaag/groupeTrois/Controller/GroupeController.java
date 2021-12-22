package com.gaag.groupeTrois.Controller;


import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Service.GroupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/groupe")
public class GroupeController {


    @Autowired
    GroupeServiceImpl groupeService;


    @GetMapping("lister")
    public List<Groupe> listeGroupe(){
        return groupeService.afficherAllGroupe();
    }

    @GetMapping("/round/promotion={annee}")
    public List<Apprenant> launchRound(@PathVariable("annee") LocalDate annee){
        return this.groupeService.allApprenant(annee);
    }
}
