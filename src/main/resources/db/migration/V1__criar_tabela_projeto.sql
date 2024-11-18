-- src/main/resources/db/migration/V1__create_projeto_table.sql

-- Criando a sequência
CREATE SEQUENCE projeto_seq START WITH 1 INCREMENT BY 1;

-- Criando a tabela
CREATE TABLE projeto (
    id BIGINT DEFAULT nextval('projeto_seq') PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);