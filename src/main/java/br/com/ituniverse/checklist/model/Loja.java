package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantidadePdvs() {
        return quantidadePdvs;
    }

    public void setQuantidadePdvs(Integer quantidadePdvs) {
        this.quantidadePdvs = quantidadePdvs;
    }

    public Integer getDiaria() {
        return diaria;
    }

    public void setDiaria(Integer diaria) {
        this.diaria = diaria;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public LocalDate getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(LocalDate dataTroca) {
        this.dataTroca = dataTroca;
    }

    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDateTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDateTime getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(LocalDateTime horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public List<Pdv> getPdvs() {
        return pdvs;
    }

    public void setPdvs(List<Pdv> pdvs) {
        this.pdvs = pdvs;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
}
