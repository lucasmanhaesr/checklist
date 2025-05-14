package br.com.ituniverse.checklist.repository;

import br.com.ituniverse.checklist.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, String> {
}
