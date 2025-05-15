package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_checklist_pdv")
public class Pdv {

    @Id
    private String id;
    private String fabricante;
    private String modelo;
    private String tag;
    private String frequencia;
    private String observacao;
    private String antes;
    private String depois;

    @JsonIgnoreProperties("pdvs")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Loja loja;


    public Pdv(){}

    public Pdv(String id, String fabricante, String modelo, String tag, String frequencia, String observacao, String antes, String depois) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tag = tag;
        this.frequencia = frequencia;
        this.observacao = observacao;
        this.antes = antes;
        this.depois = depois;
    }

    public Pdv(String id, String fabricante, String modelo, String tag, String frequencia, String observacao, String antes, String depois, Loja loja) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tag = tag;
        this.frequencia = frequencia;
        this.observacao = observacao;
        this.antes = antes;
        this.depois = depois;
        this.loja = loja;
    }
}
