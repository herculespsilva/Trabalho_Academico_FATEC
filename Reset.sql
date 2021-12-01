drop user 'user'@'localhost';
drop schema anotacao;

create schema anotacao;

use anotacao;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on anotacao.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table for_formulario (
  for_id bigint unsigned not null auto_increment,
  for_usr_id bigint unsigned not null,
  for_modelo varchar(50) not null,
  for_valor_automovel decimal (8,2),
  for_depreciacao decimal (8,2),

  primary key (for_id),
  foreign key for_usr_fk (for_usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_senha)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C'),
           ('victor', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C'),
           ('hercules', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');

insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN'),
           ('ROLE_USUARIO');

insert into uau_usuario_autorizacao values (1, 1), (2, 2), (3, 2);

insert into for_formulario (for_usr_id, for_modelo, for_valor_automovel) 
    values (2, 'Corolla', 120000),
           (3, 'fusca', 5000);