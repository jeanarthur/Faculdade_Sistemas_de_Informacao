-- Exercício_1
-- Escrever o script DDL para o modelo físico.
--  a) Escrever as restrições de chave estrangeira para o modelo físico.
CREATE TABLE Livro (
    etiqueta INTEGER NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    ano_lancamento INTEGER NOT NULL,
    qtd_copias INTEGER NOT NULL,
    CONSTRAINT livro_pk PRIMARY KEY (etiqueta)
);

CREATE TABLE Cartao (
    numero INTEGER NOT NULL,
    status VARCHAR(15) NOT NULL,
    creditos INTEGER NOT NULL,
    email VARCHAR(50) NOT NULL,
    CONSTRAINT cartao_pk PRIMARY KEY (numero)
);

CREATE TABLE Cliente (
    email VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    numero INTEGER NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (email),
    CONSTRAINT cliente_cartao_fk FOREIGN KEY (numero) REFERENCES Cartao (numero)
);


CREATE TABLE Autor (
    cpf NUMERIC NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    data_nascimento DATE NOT NULL,
    qtd_livros INTEGER NOT NULL,
    CONSTRAINT autor_pk PRIMARY KEY (cpf)
);

CREATE TABLE Escreve (
    cpf NUMERIC NOT NULL,
    etiqueta INTEGER NOT NULL,
    CONSTRAINT escreve_pk PRIMARY KEY (cpf, etiqueta),
    CONSTRAINT escreve_autor_fk FOREIGN KEY (cpf) REFERENCES Autor (cpf),
    CONSTRAINT escreve_livro_fk FOREIGN KEY (etiqueta) REFERENCES Livro (etiqueta)
);

CREATE TABLE Aluga (
    email VARCHAR(50) NOT NULL,
    etiqueta INTEGER NOT NULL,
    data_saida DATE NOT NULL,
    data_devolucao DATE NULL,
    CONSTRAINT aluga_pk PRIMARY KEY (email, etiqueta, data_saida),
    CONSTRAINT aluga_cliente_fk FOREIGN KEY (email) REFERENCES Cliente (email),
    CONSTRAINT aluga_livro_fk FOREIGN KEY (etiqueta) REFERENCES Livro (etiqueta)
);

-- Exercício_2
-- Escrevar um comando para criar uma coluna nova, chamada ATIVO, na tabela de Cartao, do tipo
-- boolean. Este campo deve aceitar valores null.
ALTER TABLE Cartao ADD COLUMN Ativo BOOLEAN NULL;

-- Exercício_3
-- Escrever os comandos para inserir dados (fictícios) em todas as tabelas.
--  a) Inserir dados para suportar os próximos exercícios.

-- Inserção na tabela Livro
INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (1, 'A Origem', 'Ficção', 2010, 10);

INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (2, 'O Senhor dos Anéis', 'Fantasia', 1954, 5);

INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (3, 'Harry Potter e a Pedra Filosofal', 'Fantasia', 1997, 8);

-- Inserção na tabela Cartao
INSERT INTO Cartao (numero, status, creditos, email)
VALUES (1, 'Ativo', 100, 'joao@email.com');

INSERT INTO Cartao (numero, status, creditos, email)
VALUES (2, 'Ativo', 50, 'jonas@email.com');

-- Inserção na tabela Cliente
INSERT INTO Cliente (email, nome, telefone, endereco, numero)
VALUES ('joao@email.com', 'Joao', '1234567890', 'Rua Principal, 123', 1);

INSERT INTO Cliente (email, nome, telefone, endereco, numero)
VALUES ('jonas@email.com', 'Jonas', '9876543210', 'Avenida Central, 456', 2);

INSERT INTO Cliente (email, nome, telefone, endereco, numero)
VALUES ('julio@email.com', 'Julio', '5555555555', 'Praça da Liberdade, 789', NULL);

-- Inserção na tabela Autor
INSERT INTO Autor (cpf, nome, cidade, data_nascimento, qtd_livros)
VALUES (12345678900, 'Christopher Nolan', 'Londres', '1970-07-30', 3);

INSERT INTO Autor (cpf, nome, cidade, data_nascimento, qtd_livros)
VALUES (98765432100, 'J.R.R. Tolkien', 'Bloemfontein', '1892-01-03', 1);

-- Inserção na tabela Escreve
INSERT INTO Escreve (cpf, etiqueta)
VALUES (12345678900, 1);

INSERT INTO Escreve (cpf, etiqueta)
VALUES (98765432100, 2);

-- Inserção na tabela Aluga
INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES ('joao@email.com', 1, '2023-06-01', '2023-06-08');

INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES ('jonas@email.com', 2, '2023-06-02', NULL);

-- Exercício_4
-- Escreva os comandos para remover o cartão do cliente joao@email.com sem remover o cliente.
--  a) atualizar o número do cartão para null.
UPDATE Cliente
SET numero = NULL
WHERE numero = 1;

--  b) deletar o cartão do cliente (ex: cartão número 1).
DELETE 
FROM Cartao 
WHERE numero = 1;

--  c) Porque não podemos deletar o cartão antes de fazer o update?
--     Porque viola a restrição da chave estrangeira, que precisa da existência de uma chave primária.

-- Exercício_5
-- Escreva um comando para atualizar a quantidade de cópias para 5 de todos os livros da categoria
-- “Ação” cujo ano de lançamento seja maior que 2015.
UPDATE Livro
SET qtd_copias = 5
WHERE categoria = 'Ação' AND ano_lancamento > 2015;

-- Exercício_6
-- Escreva os comandos para inserir os seguintes dados na tabela Aluga:
-- email | etiqueta | Data de saída | Data de devolução
-- joao@email.com | 123 | 01/06/2023 | 03/06/2023
-- jonas@email.com | 456 | 02/06/2023 | 05/06/2023
-- julio@email.com | 789 | 01/06/2023 | -
INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES('joao@email.com', 2, '01/06/2023', '03/06/2023');

INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES('jonas@email.com', 3, '02/06/2023', '05/06/2023');

INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES('julio@email.com', 1, '01/06/2023', NULL);

-- Exercicio_7
-- Escreva um INSERT que viole a chave primária da tabela Aluga.
--  a) Explique o motivo da violação.
--    O email, que é uma pfk precisa existir na tabela cliente, pois por ser fk, depende de uma pk.

INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES('jean@email.com', 1, '06/06/2023', NULL);

-- Exercicio_8
-- Escreva as seguintes consultas:
--  a) Mostrar o e-mail e a data de saída do livro com etiqueta 1.
SELECT email, data_saida
FROM Aluga
WHERE etiqueta = 1;

--  b) Mostrar as etiquetas dos livros alugados pelo João.
SELECT etiqueta
FROM Aluga
WHERE email = 'joao@email.com';

--  c) Mostrar o nome e telefone dos clientes que não possuem cartão.
SELECT nome, telefone
FROM Cliente
WHERE numero IS NULL;

--  d) Mostrar o nome e e-mail dos clientes que usam e-mail do gmail.
SELECT nome, email
FROM Cliente
WHERE email LIKE '%gmail%';

--  e) Mostrar o número dos cartões com status “BLOQUEADO” que possuem saldo positivo.
SELECT numero
FROM Cartao
WHERE status = 'BLOQUEADO' AND creditos > 0;

--  f) Mostrar o número da etiqueta e a data de saída dos livros que ainda não foram devolvidos.
SELECT etiqueta, data_saida
FROM Aluga
WHERE data_devolucao IS NULL;

--  g) Mostrar o e-mail dos clientes que possuem livros emprestados.
SELECT email
FROM Aluga
WHERE data_devolucao IS NULL;

-- Exercício_9
-- Escreva dois comandos de DELETE que violem 2 restrições de chaves estrangeiras diferentes.
--  a) Explique o motivo da violação.

-- Viola a restrição aluga_cliente_fk, pois possui uma fk desse cliente na tabela Aluga.
DELETE
FROM Cliente
WHERE email = 'joao@email.com';

-- Viola a restrição escreve_autor_fk, pois possui uma fk desse cliente na tabela Escreve
DELETE
FROM Autor
WHERE cpf = 12345678900;