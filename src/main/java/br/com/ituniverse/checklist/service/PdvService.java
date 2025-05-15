package br.com.ituniverse.checklist.service;

import br.com.ituniverse.checklist.model.Pdv;
import br.com.ituniverse.checklist.repository.LojaRepository;
import br.com.ituniverse.checklist.repository.PdvRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class PdvService {

    private final PdvRepository pdvRepository;
    private final LojaRepository lojaRepository;

    public PdvService(PdvRepository pdvRepository, LojaRepository lojaRepository) {
        this.pdvRepository = pdvRepository;
        this.lojaRepository = lojaRepository;
    }

    public ResponseEntity<Pdv> criar(Pdv pdv) {
        return lojaRepository.findById(pdv.getLoja().getId())
            .map(
                lojaOpt -> {
                    Optional<Pdv> pdvOpt= pdvRepository.findById(pdv.getId());
                    if (pdvOpt.isPresent()) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma Pdv com esse id: " + pdv.getId());
                    }
                    else {
                        return ResponseEntity.status(HttpStatus.CREATED).body(pdvRepository.save(pdv));
                    }
                }
            )
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com esse id: " + pdv.getLoja().getId()));
    }

    public ResponseEntity<List<Pdv>> criarPorLista(List<Pdv> listaPdvs){
        return ResponseEntity.status(HttpStatus.CREATED).body(pdvRepository.saveAll(listaPdvs));
    }

    public ResponseEntity<Pdv> atualizar(Pdv pdv) {
        return lojaRepository.findById(pdv.getLoja().getId())
            .map(lojaOpt -> pdvRepository.findById(pdv.getId())
                .map( pdvOpt -> ResponseEntity.status(HttpStatus.OK).body(pdvRepository.save(pdv)))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe PDV com esse id: " + pdv.getId()))
            )
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe loja com esse id: " + pdv.getLoja().getId()));
    }

    public ResponseEntity<Pdv> buscarPorId(String id){
        return pdvRepository.findById(id)
          .map( pdvOpt -> ResponseEntity.status(HttpStatus.OK).body(pdvOpt))
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe PDV com esse id: " + id));
    }

    public ResponseEntity<List<Pdv>> listar() {
      return ResponseEntity.status(HttpStatus.OK).body(pdvRepository.findAll());
    }

    public void deletar(String id) {
        pdvRepository.findById(id).ifPresentOrElse(
            pdvOpt -> pdvRepository.delete(pdvOpt),
            () -> { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe PDV com esse id: " + id); }
        );
    }

}
