create database tcd;

use tcd;

CREATE TABLE `cliente` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) DEFAULT '0',
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` bigint unsigned NOT NULL,
  `endereco` varchar(500) DEFAULT NULL,
  `cpf` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB; 


CREATE TABLE `autor` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) DEFAULT '0',
  `nome` varchar(255) NOT NULL,
  `nascimento` date NOT NULL,
  `falecimento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `idioma` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) DEFAULT '0',
  `idioma` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `idioma`(`idioma`)
) ENGINE=InnoDB;


 CREATE TABLE `editora` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) DEFAULT '0',
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cnpj` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB;

CREATE TABLE `genero` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) DEFAULT '0',
  `genero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB;

 CREATE TABLE `livro` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) NOT NULL DEFAULT '0',
  `titulo` varchar(255) NOT NULL,
  `anoDePublicacao` smallint(6) NOT NULL,
  `genero_id` bigint unsigned NOT NULL,
  `editora_id` bigint unsigned NOT NULL,
  `idioma_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `genero_id` (`genero_id`),
  KEY `editora_id` (`editora_id`),
  KEY `idioma_id` (`idioma_id`),
  CONSTRAINT `livro_ibfk_1` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`),
  CONSTRAINT `livro_ibfk_2` FOREIGN KEY (`editora_id`) REFERENCES `editora` (`id`),
  CONSTRAINT `livro_ibfk_3` FOREIGN KEY (`idioma_id`) REFERENCES `idioma` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `autorlivro` (
  `autor_id` bigint unsigned NOT NULL,
  `livro_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`autor_id`,`livro_id`),
  KEY `livro_id` (`livro_id`),
  CONSTRAINT `autorlivro_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`),
  CONSTRAINT `autorlivro_ibfk_2` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `exemplar` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `excluido` tinyint(1) NOT NULL DEFAULT '0',
  `livro_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `livro_id` (`livro_id`),
  CONSTRAINT `exemplar_ibfk_1` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `emprestimo` (
  `id` bigint unsigned NOT NULL,
  `excluido` tinyint(1) NOT NULL DEFAULT '0',
  `cliente_id` bigint unsigned NOT NULL,
  `dataEmprestimo` datetime NOT NULL,
  `dataLimiteDevolucao` datetime NOT NULL,
  `dataDevolvido` datetime DEFAULT NULL,
  `dataPagamentoMulta` datetime DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `emprestimo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `exemplar` (`id`)
) ENGINE=InnoDB; 


create table usuario(
    id serial,
    excluido boolean default false,
    nome varchar(35), 
    usuario varchar(255),
    senha varchar(255),
    administrador boolean,
    primary key (id),
    foreign key(id) references cliente(id)    
) engine=innodb;


insert into cliente (id, excluido,  nome, email, telefone, endereco, cpf) values (default, default, "Administrador", "adm@mail.com", 123456789, "Brasil", USAR_UM_CPF_VALIDO_AQUI);

insert into usuario (id, excluido, nome, usuario, senha, administrador) values (1, default, "Administrador", "admin", MD5("Dr@g0nC@rB0n&T01234"), true); 