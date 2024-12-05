package edu.ifrn.tsi.sgpt.domain.projeto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "projeto")
@Table(name = "projeto")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_seq_generator")
    @SequenceGenerator(name = "projeto_seq_generator", sequenceName = "projeto_SEQ", allocationSize = 1)
    private Long id;
    @NotBlank(message = "O nome do projeto é obrigatório")
    private String nome;

    @CreatedDate
    @Column(name = "data_criacao ", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "data_ultima_modificacao", nullable = false)
    private LocalDateTime dataUltimaModificacao;

}
