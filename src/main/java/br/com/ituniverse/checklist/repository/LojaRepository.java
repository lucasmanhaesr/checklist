package br.com.ituniverse.checklist.repository;

import br.com.ituniverse.checklist.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LojaRepository extends JpaRepository<Loja, String> {
    List<Loja> findLojaByUf(String uf);
}
