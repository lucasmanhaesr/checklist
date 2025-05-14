package br.com.ituniverse.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class servidor {

    private String id;
    private String fabricante;
    private String modelo;
    private String tag;
    private String tamanhoMemoria;
    private String frequencia;
    private String observacao;

}
