package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "tb_checklist_loja")
public class Loja {

    @Id
    private String id;
    private Integer quantidadePdvs;
    private Integer diaria;
    private String uf;
    private String status;
    private String tecnico;
    private LocalDate dataTroca;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioTermino;

    @JsonIgnoreProperties("loja")
    @OneToMany(mappedBy = "loja", cascade = CascadeType.REMOVE)
    private List<Pdv> pdvs;

    @JsonIgnoreProperties("loja")
    @OneToOne(mappedBy = "loja")
    private Servidor servidor;

    public Loja() {}

    public Loja(String id, Integer quantidadePdvs, Integer diaria, String uf, String status, String tecnico, LocalDate dataTroca, LocalDateTime horarioInicio, LocalDateTime horarioTermino) {
        this.id = id;
        this.quantidadePdvs = quantidadePdvs;
        this.diaria = diaria;
        this.uf = uf;
        this.status = status;
        this.tecnico = tecnico;
        this.dataTroca = dataTroca;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Loja(String id, Integer quantidadePdvs, Integer diaria, String uf, String status, String tecnico, LocalDate dataTroca, LocalDateTime horarioInicio, LocalDateTime horarioTermino, List<Pdv> pdvs, Servidor servidor) {
        this.id = id;
        this.quantidadePdvs = quantidadePdvs;
        this.diaria = diaria;
        this.uf = uf;
        this.status = status;
        this.tecnico = tecnico;
        this.dataTroca = dataTroca;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.pdvs = pdvs;
        this.servidor = servidor;
    }

}
