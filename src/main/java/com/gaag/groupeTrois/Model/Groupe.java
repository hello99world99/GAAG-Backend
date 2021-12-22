package com.gaag.groupeTrois.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private int nbrGroupe;

    @NotNull
    @NotBlank
    private int numeroGroupe;

    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIVER;

    @ManyToOne
    private Apprenant apprenant;
}
