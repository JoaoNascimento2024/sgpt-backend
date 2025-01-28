package edu.ifrn.tsi.sgpt.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.ifrn.tsi.sgpt.domain.usuario.DadosAutenticacao;
import edu.ifrn.tsi.sgpt.domain.usuario.DadosTokenJWT;
import edu.ifrn.tsi.sgpt.domain.usuario.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ifrn.tsi.sgpt.security.ServiceToken;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

  @Autowired
  private ServiceToken serviceToken;

  @PostMapping 
  public ResponseEntity<Object> efetuarLogin(@RequestBody DadosAutenticacao dados){
    var dadosAutenticacao = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
    //System.out.println(dadosAutenticacao.getPrincipal());
    var tokenJWT = serviceToken.gerarToken(dadosAutenticacao.getPrincipal().toString());
    //System.out.println(tokenJWT);
    return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
  }



}
