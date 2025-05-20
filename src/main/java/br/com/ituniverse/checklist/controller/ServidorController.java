package br.com.ituniverse.checklist.controller;

import br.com.ituniverse.checklist.dto.CriarServidorDto;
import br.com.ituniverse.checklist.model.Servidor;
import br.com.ituniverse.checklist.service.ServidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servidor")
@CrossOrigin(allowedHeaders = "*", origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ServidorController {

    private final ServidorService servidorService;

    public ServidorController(ServidorService servidorService) {
        this.servidorService = servidorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Servidor> criar(@RequestBody CriarServidorDto criarServidorDto) {
        return servidorService.criar(criarServidorDto);
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
    public ResponseEntity<Servidor> buscarServidorPorId(@PathVariable String id) {
        return servidorService.buscarServidorPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Servidor>> listarServidores(){
        return servidorService.listar();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") String id) {
        servidorService.deletar(id);
    }

}
