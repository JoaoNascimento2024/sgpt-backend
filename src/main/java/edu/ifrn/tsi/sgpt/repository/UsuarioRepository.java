package edu.ifrn.tsi.sgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifrn.tsi.sgpt.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
