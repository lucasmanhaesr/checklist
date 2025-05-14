package br.com.ituniverse.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class loja {

    private String id;
    private Integer QuantidadePdvs;
    private Integer diaria;
    private String uf;

    private LocalDate dataTroca;
    private String status;
    private String tecnico;

}
