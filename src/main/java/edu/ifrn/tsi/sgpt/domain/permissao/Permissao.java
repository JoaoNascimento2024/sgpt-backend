package edu.ifrn.tsi.sgpt.domain.permissao;

import java.util.Set;
import edu.ifrn.tsi.sgpt.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "permissao")
@Table(name = "permissao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_seq_generator")
    @SequenceGenerator(name = "permissao_seq_generator", sequenceName = "permissao_seq", allocationSize = 1)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "permissoes")
    private Set<Usuario> usuarios;
  
}
