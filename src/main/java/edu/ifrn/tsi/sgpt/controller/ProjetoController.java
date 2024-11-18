package edu.ifrn.tsi.sgpt.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.ifrn.tsi.sgpt.domain.projeto.Projeto;
import edu.ifrn.tsi.sgpt.repository.ProjetoRepository;

import org.springframework.web.bind.annotation.PostMapping;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    
    @PostMapping
    @Transactional
    public ResponseEntity<URI> cadastrarProjeto(@RequestBody Projeto projeto, 
                    UriComponentsBuilder uriComponentsBuilder){
        projetoRepository.save(projeto);
        URI uri = uriComponentsBuilder.path("/projetos/{id}").buildAndExpand(
            projeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")   
    public ResponseEntity<Projeto> detalharProjeto(@PathVariable("id") Long id){
        var projeto = projetoRepository.getReferenceById(id);
        return ResponseEntity.ok(projeto);
    }
    
}
