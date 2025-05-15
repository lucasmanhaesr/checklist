package br.com.ituniverse.checklist.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_checklist_pdv")
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Loja loja;

}
