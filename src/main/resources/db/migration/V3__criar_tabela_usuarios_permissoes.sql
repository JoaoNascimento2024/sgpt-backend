-- Criando a sequência
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1;
-- Criando a sequência
CREATE SEQUENCE permissao_seq START WITH 1 INCREMENT BY 1;

create table usuario (
    id bigint DEFAULT nextval('usuario_seq') PRIMARY KEY,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);

ALTER TABLE usuario
ADD CONSTRAINT usuario_constraint UNIQUE (email);

create table permissao (
    id bigint DEFAULT nextval('permissao_seq') PRIMARY KEY,
    nome varchar(255) not null
);

ALTER TABLE permissao
ADD CONSTRAINT permissao_constraint UNIQUE (nome);

create table usuario_permissao (
    id bigserial not null primary key,
    usuario_id bigint not null,
    permissao_id bigint not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (permissao_id) references permissao(id)
);

insert into permissao (nome) values ('ROLE_ADMIN');
insert into permissao (nome) values ('ROLE_USER');
