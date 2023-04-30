CREATE DATABASE SUCOS;

CREATE {DATABASE / SCHEMA} [IF NOT EXISTS] DB_NAME
[CREATE_SPECIFICATION]...

CREATE_SPECIFICATION:
[DEFAULLT] CHARACTER SET [=] CHARSET_NAME
[DEFAULLT] COLLATE [=] COLLATION_NAME
DEFAULLT ENCRYPTION [=] {'Y' / 'N'}


Onde o BD é criado fisicamente?
c:\programdata\mysql\mysql server8.0

Arquivo my.ini ==> arquivo de inicialização do SQL
Abrindo este arquivo em modo editar, vamos encontrar a linha:
datadir = c:\programdata\mysql\mysql server8.0/Data
Seguindo o caminho, encontramos a pasta com o nome do BD criado
