package br.com.ituniverse.checklist.repository;

import br.com.ituniverse.checklist.model.Loja;
import br.com.ituniverse.checklist.model.Pdv;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PdvRepository extends JpaRepository<Pdv, String> {
    List<Pdv> findPdvByLoja(Loja loja);

    Loja loja(Loja loja);
}
