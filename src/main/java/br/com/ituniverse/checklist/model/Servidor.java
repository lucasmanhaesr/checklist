package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_checklist_servidor")
public class Servidor {

    @Id
    private String id;
    private String fabricante;
    private String modelo;
    private String tag;
    private String tamanhoMemoria;
    private String frequencia;
    private String observacao;
    private String antes;
    private String depois;

    @JsonIgnoreProperties({"servidor"})
    @OneToOne(cascade = CascadeType.REMOVE)
    private Loja loja;

    public Servidor(){}

    public Servidor(String id, String fabricante, String modelo, String tag, String tamanhoMemoria, String frequencia, String observacao, String antes, String depois) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tag = tag;
        this.tamanhoMemoria = tamanhoMemoria;
        this.frequencia = frequencia;
        this.observacao = observacao;
        this.antes = antes;
        this.depois = depois;
    }

    public Servidor(String id, String fabricante, String modelo, String tag, String tamanhoMemoria, String frequencia, String observacao, String antes, String depois, Loja loja) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tag = tag;
        this.tamanhoMemoria = tamanhoMemoria;
        this.frequencia = frequencia;
        this.observacao = observacao;
        this.antes = antes;
        this.depois = depois;
        this.loja = loja;
    }

}
