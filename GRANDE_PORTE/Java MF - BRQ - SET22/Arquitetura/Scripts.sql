-- 13 de outubro

CREATE DATABASE IF NOT EXISTS db_curso_java;

use db_curso_java;

CREATE TABLE IF NOT EXISTS usuarios(
	id_user int primary key auto_increment,
	nome_user varchar(40),
	email_user varchar(50)
);

-- 17 de outubro

INSERT INTO usuarios
	(nome_user, email_user)
VALUES('Elys', 'elys@brq.com');

DELETE FROM usuarios
	where id_user = 1000;

-- 18 de outubro

ALTER TABLE usuarios
	ADD COLUMN idade int;

describe usuarios ;

CREATE INDEX usuarios_idade
	ON usuarios (idade);

ALTER TABLE usuarios
	DROP COLUMN idade;
