create table usuario (
    id serial not null primary key,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);

ALTER TABLE usuario
ADD CONSTRAINT usuario_constraint UNIQUE (email);

create table permissao (
    id serial not null primary key,
    nome varchar(255) not null
);

ALTER TABLE permissao
ADD CONSTRAINT permissao_constraint UNIQUE (nome);

create table usuario_permissao (
    id serial not null primary key,
    usuario_id integer not null,
    permissao_id integer not null,
    foreign key (usuario_id) references usuario(id),
    foreign key (permissao_id) references permissao(id)
);

insert into permissao (nome) values ('ROLE_ADMIN');
insert into permissao (nome) values ('ROLE_USER');