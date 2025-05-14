package br.com.ituniverse.checklist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "tb_checklist_loja")
@AllArgsConstructor
@NoArgsConstructor
public class Loja {

    @Id
    private String id;
    private Integer QuantidadePdvs;
    private Integer diaria;
    private String uf;
    private LocalDate dataTroca;
    private String status;
    private String tecnico;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.REMOVE)
    private List<Pdv> pdvs;

    @OneToOne(mappedBy = "loja")
    private Servidor servidor;

}
