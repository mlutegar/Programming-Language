create database if not exists db01;

create table if not exists aluno(
  id int primary key auto_increment,
  nome varchar(150) not null,
  email varchar(150) not null unique,
  matricula int not null unique,
  sexo varchar(1) not null
);