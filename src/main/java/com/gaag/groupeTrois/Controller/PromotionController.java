package com.gaag.groupeTrois.Controller;

import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Service.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/promotion")
public class PromotionController {
    @Autowired
    PromotionServiceImpl promotionService;

    @GetMapping("/list")
    List<Promotion> afficherPromotion(){
        return promotionService.afficherPromotion();
    }

    @GetMapping("/get/date={promotion}")
    Promotion getPromByDate(@PathVariable("promotion") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate promotion){
        return promotionService.getPromotionByAnnee(promotion);
    }

    @PostMapping("/ajouter")
    String ajouter_promotion(@RequestBody Promotion promotion){
        return promotionService.ajouterPromotion(promotion);
    }

    @PutMapping("/modifier/{id}")
    String modifierPromotion(@RequestBody Promotion promotion, @PathVariable Long id){
        return promotionService.modifierPromotion(promotion, id);
    }

    @DeleteMapping("/supprimer/{id}")
    String supprimerPromotion(@PathVariable Long id){
        return promotionService.supprimerPromotionById(id);
    }

}
