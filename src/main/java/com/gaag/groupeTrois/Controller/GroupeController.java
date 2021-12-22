package com.gaag.groupeTrois.Controller;


import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Service.GroupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/groupe")
public class GroupeController {


    @Autowired
    GroupeServiceImpl groupeService;


    @GetMapping("lister")
    List<Groupe> listeGroupe(){

        return groupeService.afficherAllGroupe();
    }
}
