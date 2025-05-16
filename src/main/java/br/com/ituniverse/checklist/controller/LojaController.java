package br.com.ituniverse.checklist.controller;

import br.com.ituniverse.checklist.model.Loja;
import br.com.ituniverse.checklist.service.LojaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loja")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Loja> criar(@RequestBody Loja loja) {
        return lojaService.criar(loja);
    }

    @PostMapping("/lista")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Loja>> criarPorLista(@RequestBody List<Loja> lojas) {
        return lojaService.criarPorLista(lojas);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Loja> atualizar(@RequestBody Loja loja) {
        return lojaService.atualizar(loja);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Loja> buscarLojaPorId(@PathVariable("id") String id) {
        return lojaService.buscarLojaPorId(id);
    }

    @GetMapping("/uf/{uf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Loja>> buscarLojaPorUf(@PathVariable("uf") String uf) {
        return lojaService.buscarLojasPorUf(uf);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Loja>> listarLojas(){
        return lojaService.listarLojas();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") String id) {
        lojaService.deletar(id);
    }

}