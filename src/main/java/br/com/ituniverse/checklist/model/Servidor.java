package br.com.ituniverse.checklist.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_checklist_servidor")
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(cascade = CascadeType.REMOVE)
    private Loja loja;

}
