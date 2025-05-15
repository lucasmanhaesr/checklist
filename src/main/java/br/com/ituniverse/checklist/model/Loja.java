package br.com.ituniverse.checklist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String status;
    private String tecnico;
    private LocalDate dataTroca;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioTermino;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.REMOVE)
    private List<Pdv> pdvs;

    @OneToOne(mappedBy = "loja")
    private Servidor servidor;

}
