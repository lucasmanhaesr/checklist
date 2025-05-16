package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tb_checklist_loja")
public class Loja {

    @Id
    private String id;
    private Integer quantidadePdvs;
    private Integer diaria;
    private String uf;

    @JsonIgnoreProperties("loja")
    @OneToMany(mappedBy = "loja", cascade = CascadeType.REMOVE)
    private List<Pdv> pdvs;

    @JsonIgnoreProperties("loja")
    @OneToOne(mappedBy = "loja")
    private Servidor servidor;

    public Loja() {}

    public Loja(String id, Integer quantidadePdvs, Integer diaria, String uf) {
        this.id = id;
        this.quantidadePdvs = quantidadePdvs;
        this.diaria = diaria;
        this.uf = uf;
    }

    public Loja(String id, Integer quantidadePdvs, Integer diaria, String uf, List<Pdv> pdvs, Servidor servidor) {
        this.id = id;
        this.quantidadePdvs = quantidadePdvs;
        this.diaria = diaria;
        this.uf = uf;
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
