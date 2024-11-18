package edu.ifrn.tsi.sgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.ifrn.tsi.sgpt.domain.projeto.Projeto;
import edu.ifrn.tsi.sgpt.repository.ProjetoRepository;

import org.springframework.web.bind.annotation.PostMapping;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    
    @PostMapping
    @Transactional
    public ResponseEntity<Projeto> cadastrarProjeto(@RequestBody Projeto projeto, UriComponentsBuilder uriComponentsBuilder){
        projetoRepository.save(projeto);
        var uri = uriComponentsBuilder.path("/projetos/{id}").buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
}
