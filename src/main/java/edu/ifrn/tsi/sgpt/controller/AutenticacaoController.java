package edu.ifrn.tsi.sgpt.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.ifrn.tsi.sgpt.domain.usuario.DadosAutenticacao;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/login")
public class AutenticacaoController {

  @PostMapping 
  public ResponseEntity<Object> efetuarLogin(@RequestBody DadosAutenticacao dados){
    var dadosAutenticacao = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
    return ResponseEntity.ok("Autenticado");
  }

  

}
