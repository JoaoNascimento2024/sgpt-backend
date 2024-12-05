package edu.ifrn.tsi.sgpt.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.ifrn.tsi.sgpt.domain.projeto.Projeto;
import edu.ifrn.tsi.sgpt.repository.ProjetoRepository;
import edu.ifrn.tsi.sgpt.service.ProjetoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoService projetoService;

   
    @PostMapping
    @Transactional
    public ResponseEntity<URI> cadastrarProjeto(@RequestBody @Valid Projeto projeto, 
                    UriComponentsBuilder uriComponentsBuilder){
        projetoRepository.save(projeto);
        URI uri = uriComponentsBuilder.path("/projetos/{id}").buildAndExpand(
            projeto.getId()).toUri();
        projetoService.cadastrarProjeto(projeto);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")   
    public ResponseEntity<Projeto> detalharProjeto(@PathVariable("id") Long id){
        var projeto = projetoRepository.getReferenceById(id);
        return ResponseEntity.ok(projeto);
    }

    @GetMapping
    public ResponseEntity<Page<Projeto>> listarProjetos(Pageable pageable) {
        Page<Projeto> projetos = projetoRepository.findAll(pageable);
        return ResponseEntity.ok(projetos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirProjeto(@PathVariable("id") Long id){
        projetoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Projeto> atualizarProjeto(@RequestBody Projeto projeto){
        var projetoAtualizado = projetoRepository.getReferenceById(projeto.getId());
        projetoAtualizado.setNome(projeto.getNome());
        return ResponseEntity.ok(projetoAtualizado);
    }

    /*
    @Getmapping
    public ResponseEntity<List<Projeto>> listarProjetos() {
            var projetos = projetoRepository.findAll();
            return ResponseEntity.ok(projetos);
        } 
     */

    
}
