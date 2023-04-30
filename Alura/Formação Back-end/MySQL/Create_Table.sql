create table tbCliente
(CPF varchar(11),
Nome varchar(100),
Endereço1 varchar(150),
Endereço2 varchar(150),
Bairro varchar (50),
Cidade varchar (50),
Estado varchar (50),
CEP varchar(8),
Idade smallint,
Sexo varchar (1),
Limite_Credito float,
Volume_Compra float,
Primeira_Compra bit(1)
 
);
Create table tbVendedores
(Matricula varchar (5),
Nome varchar (100),
Percentual_Comissao float);
