package br.com.ituniverse.checklist.dto;

import br.com.ituniverse.checklist.model.Loja;

public record CriarServidorDto(
        String id,
        String fabricante,
        String modelo,
        String tag,
        String tamanhoMemoria,
        String frequencia,
        Loja loja
) { }
