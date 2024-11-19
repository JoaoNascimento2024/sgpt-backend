package edu.ifrn.tsi.sgpt.domain.projeto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_seq_generator")
    @SequenceGenerator(name = "projeto_seq_generator", sequenceName = "projeto_SEQ", allocationSize = 1)
    private Long id;
    @NotBlank(message = "O nome do projeto é obrigatório")
    private String nome;
}
