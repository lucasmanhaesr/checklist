package br.com.ituniverse.checklist.service;

import br.com.ituniverse.checklist.model.Loja;
import br.com.ituniverse.checklist.repository.LojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public ResponseEntity<Loja> criar(Loja loja){
        Optional<Loja> lojaOptional = lojaRepository.findById(loja.getId());
        if(lojaOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Loja já cadastrada com o id: " + lojaOptional.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(lojaRepository.save(loja));
        }
    }

    public ResponseEntity<Loja> atualizar(Loja loja){
        Optional<Loja> lojaOptional = lojaRepository.findById(loja.getId());
        if(lojaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(lojaRepository.save(loja));
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não existe loja com o id: " + loja.getId());
        }
    }

    public ResponseEntity<Loja> buscarPorId(String id){
        Optional<Loja> lojaOptional = lojaRepository.findById(id);
        if(lojaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(lojaOptional.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com o id: " + id);
        }
    }

    public ResponseEntity<List<Loja>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(lojaRepository.findAll());
    }

    public void remover(String id){
        Optional<Loja> lojaOptional = lojaRepository.findById(id);
        if(lojaOptional.isPresent()){
            lojaRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com o id: " + id);
        }
    }

}
