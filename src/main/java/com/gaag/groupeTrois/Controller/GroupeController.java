package com.gaag.groupeTrois.Controller;


import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Service.GroupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/groupe")
public class GroupeController {


    @Autowired
    GroupeServiceImpl groupeService;


    @GetMapping("lister")
    public List<Groupe> listeGroupe(){
        return groupeService.afficherAllGroupe();
    }

    @GetMapping("/repartir/promotion={annee}&g={g}&a={a}&t={t}")
    public ArrayList<ArrayList<Groupe>> launchRound(
            @PathVariable("annee")
            @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate annee,
            @PathVariable("g") int g,
            @PathVariable("a") int a,
            @PathVariable("t") String trier
            ){
        return this.groupeService.allApprenant(annee, g, a, trier);
    }
}
