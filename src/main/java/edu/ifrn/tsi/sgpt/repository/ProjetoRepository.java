package edu.ifrn.tsi.sgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ifrn.tsi.sgpt.domain.projeto.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    
} 
