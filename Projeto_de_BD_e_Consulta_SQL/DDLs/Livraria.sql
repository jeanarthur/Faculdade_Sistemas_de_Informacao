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