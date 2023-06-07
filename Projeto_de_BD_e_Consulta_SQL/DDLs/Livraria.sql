#Exercício_1;
CREATE TABLE Livro (
    etiqueta INTEGER NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    ano_lancamento INTEGER NOT NULL,
    qtd_copias INTEGER NOT NULL,
    CONSTRAINT livro_pk PRIMARY KEY (etiqueta)
);

CREATE TABLE Cliente (
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    numero INTEGER NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (email),
    CONSTRAINT cliente_cartao_fk FOREIGN KEY (numero) REFERENCES Cartao (numero)
);


CREATE TABLE Cartao (
    numero INTEGER NOT NULL,
    status VARCHAR(15) NOT NULL,
    creditos INTEGER NOT NULL,
    email VARCHAR(50) NOT NULL,
    CONSTRAINT cartao_pk PRIMARY KEY (numero)
);

CREATE TABLE Autor (
    cpf NUMERIC NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    data_nascimento DATE NOT NULL,
    qtd_livros INTEGER NOT NULL,
    CONSTRAINT livro_pk PRIMARY KEY (etiqueta)
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
    data_devolucao DATE NULL
    CONSTRAINT aluga_pk PRIMARY KEY (email, etiqueta, data_saida),
    CONSTRAINT aluga_cliente_fk FOREIGN KEY (email) REFERENCES Cliente (email),
    CONSTRAINT aluga_livro_fk FOREIGN KEY (etiqueta) REFERENCES Livro (etiqueta)
);

#Exercício_2;
ALTER TABLE Cartao ADD COLUMN Ativo BOOLEAN NULL;

#Exercício_3;
-- Inserção na tabela Livro
INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (1, 'A Origem', 'Ficção', 2010, 10);

INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (2, 'O Senhor dos Anéis', 'Fantasia', 1954, 5);

INSERT INTO Livro (etiqueta, titulo, categoria, ano_lancamento, qtd_copias)
VALUES (3, 'Harry Potter e a Pedra Filosofal', 'Fantasia', 1997, 8);


-- Inserção na tabela Cliente
INSERT INTO Cliente (email, telefone, endereco, numero)
VALUES ('exemplo1@gmail.com', '1234567890', 'Rua Principal, 123', 1);

INSERT INTO Cliente (email, telefone, endereco, numero)
VALUES ('exemplo2@gmail.com', '9876543210', 'Avenida Central, 456', 2);

INSERT INTO Cliente (email, telefone, endereco, numero)
VALUES ('exemplo3@gmail.com', '5555555555', 'Praça da Liberdade, 789', NULL);


-- Inserção na tabela Cartao
INSERT INTO Cartao (numero, status, creditos, email)
VALUES (1, 'Ativo', 100, 'exemplo1@gmail.com');

INSERT INTO Cartao (numero, status, creditos, email)
VALUES (2, 'Ativo', 50, 'exemplo2@gmail.com');


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
VALUES ('exemplo1@gmail.com', 1, '2023-06-01', '2023-06-08');

INSERT INTO Aluga (email, etiqueta, data_saida, data_devolucao)
VALUES ('exemplo2@gmail.com', 2, '2023-06-02', NULL);

