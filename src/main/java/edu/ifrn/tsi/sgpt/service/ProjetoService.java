package edu.ifrn.tsi.sgpt.service;

import org.springframework.stereotype.Service;

import edu.ifrn.tsi.sgpt.domain.projeto.Projeto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjetoService {

  public void cadastrarProjeto(Projeto projeto) {
    log.info("Cadastrando projeto: {}", projeto);
  }

}
