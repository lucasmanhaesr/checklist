package br.com.ituniverse.checklist.service;

import br.com.ituniverse.checklist.model.Servidor;
import br.com.ituniverse.checklist.repository.LojaRepository;
import br.com.ituniverse.checklist.repository.ServidorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {

    private final ServidorRepository servidorRepository;
    private final LojaRepository lojaRepository;

    public ServidorService(ServidorRepository servidorRepository, LojaRepository lojaRepository) {
        this.servidorRepository = servidorRepository;
        this.lojaRepository = lojaRepository;
    }

    public ResponseEntity<Servidor> criar(Servidor servidor) {
        return lojaRepository.findById(servidor.getLoja().getId())
            .map( lojaOpt -> {
                Optional<Servidor> servidorOpt = servidorRepository.findById(servidor.getId());
                if (servidorOpt.isPresent()) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe servidor com esse id: " + servidor.getId());
                }
                else{
                    return ResponseEntity.status(HttpStatus.CREATED).body(servidorRepository.save(servidor));
                }
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com esse id: " + servidor.getId()));
    }

    public ResponseEntity<List<Servidor>> criarPorLista(List<Servidor> listaServidores){
        return ResponseEntity.status(HttpStatus.CREATED).body(servidorRepository.saveAll(listaServidores));
    }

    public ResponseEntity<Servidor> atualizar(Servidor servidor) {
        return lojaRepository.findById(servidor.getLoja().getId())
            .map(
                lojaOpt -> servidorRepository.findById(servidor.getId())
                    .map( servidorOpt -> ResponseEntity.status(HttpStatus.OK).body(servidorRepository.save(servidor)))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Servidor com esse id: " + servidor.getId()))
            )
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com esse id: " + servidor.getLoja().getId()));
    }

    public ResponseEntity<Servidor> buscarPorId(String id){
        return servidorRepository.findById(id)
            .map(servidorOpt -> ResponseEntity.status(HttpStatus.OK).body(servidorOpt))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Servidor com esse id: " + id));
    }

    public ResponseEntity<List<Servidor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(servidorRepository.findAll());
    }

    public void deletar(String id) {
        servidorRepository.findById(id).ifPresentOrElse(
            servidorOpt -> servidorRepository.delete(servidorOpt),
            () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe servidor com esse id: " + id); }
        );
    }

}
