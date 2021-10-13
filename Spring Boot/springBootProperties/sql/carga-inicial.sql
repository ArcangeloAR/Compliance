CREATE DATABASE db_propriedades;
USE db_propriedades;
CREATE TABLE propriedade (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
categoria VARCHAR(200),
subcategoria VARCHAR(200),
nome VARCHAR(200),
valor VARCHAR(512) default '',
descricao VARCHAR(1000),
PRIMARY KEY (id),
UNIQUE INDEX nome_unique (nome ASC));