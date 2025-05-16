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

    public ResponseEntity<List<Loja>> criarPorLista(List<Loja> listaLojas){
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaRepository.saveAll(listaLojas));
    }

    public ResponseEntity<Loja> atualizar(Loja loja){
        return lojaRepository.findById(loja.getId())
            .map( lojaOpt -> ResponseEntity.status(HttpStatus.OK).body(lojaRepository.save(loja)))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com o id: " + loja.getId()));
    }

    public ResponseEntity<Loja> buscarLojaPorId(String id){
        return lojaRepository.findById(id)
                .map(lojaOpt -> ResponseEntity.status(HttpStatus.OK).body(lojaOpt))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com o id: " + id));
    }

    public ResponseEntity<List<Loja>> buscarLojasPorUf(String uf){
        return ResponseEntity.status(HttpStatus.OK).body(lojaRepository.findLojaByUf(uf));
    }

    public ResponseEntity<List<Loja>> listarLojas(){
        return ResponseEntity.status(HttpStatus.OK).body(lojaRepository.findAll());
    }

    public void deletar(String id){
        lojaRepository.findById(id)
            .ifPresentOrElse(
                lojaOpt -> lojaRepository.delete(lojaOpt),
                () -> {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com o id: " + id);}
            );
    }

}
