package edu.ifrn.tsi.sgpt.domain.projeto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    private String nome;
}
