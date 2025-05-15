package br.com.ituniverse.checklist.controller;

import br.com.ituniverse.checklist.model.Servidor;
import br.com.ituniverse.checklist.service.ServidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servidor")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ServidorController {

    private final ServidorService servidorService;

    public ServidorController(ServidorService servidorService) {
        this.servidorService = servidorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Servidor> criar(@RequestBody Servidor servidor) {
        return servidorService.criar(servidor);
    }

    @PostMapping("/lista")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Servidor>> criarPorLista(@RequestBody List<Servidor> listaServidores) {
        return servidorService.criarPorLista(listaServidores);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Servidor> atualizar(@RequestBody Servidor servidor) {
        return servidorService.atualizar(servidor);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Servidor> buscarPorId(@PathVariable String id) {
        return servidorService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Servidor>> listar(){
        return servidorService.listar();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") String id) {
        servidorService.deletar(id);
    }

}
