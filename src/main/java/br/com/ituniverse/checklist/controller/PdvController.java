package br.com.ituniverse.checklist.controller;

import br.com.ituniverse.checklist.model.Pdv;
import br.com.ituniverse.checklist.service.PdvService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pdv")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PdvController {

    private final PdvService pdvService;

    public PdvController(PdvService pdvService) {
        this.pdvService = pdvService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pdv> criar(@RequestBody Pdv pdv) {
        return pdvService.criar(pdv);
    }

    @PostMapping("/lista")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Pdv>> criarPorLista(@RequestBody List<Pdv> listapdvs) {
        return pdvService.criarPorLista(listapdvs);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pdv> atualizar(@RequestBody Pdv pdv) {
        return pdvService.atualizar(pdv);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pdv> buscarPdvPorId(@PathVariable("id") String id) {
        return pdvService.buscarPdvPorId(id);
    }

    @GetMapping("/loja/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Pdv>> buscarPdvPorLoja(@PathVariable("id") String id) {
        return pdvService.listarPdvsPorLoja(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Pdv>> listar() {
        return pdvService.listarPdvs();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable String id) {
        pdvService.deletar(id);
    }

}
