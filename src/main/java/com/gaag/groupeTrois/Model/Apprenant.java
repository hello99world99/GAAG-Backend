package com.gaag.groupeTrois.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    @NotNull
    private Promotion promotion;

    @NotBlank
    private String nomComplet;

    @NotNull
    @Email
    private String email;

    @NumberFormat
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIVER;
}
