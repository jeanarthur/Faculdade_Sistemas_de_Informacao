CREATE TABLE Curso (
    codigo VARCHAR(5) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    preco REAL NOT NULL,
    duracao INTEGER NOT NULL
);
ALTER TABLE Curso ADD CONSTRAINT curso_pk PRIMARY KEY (codigo);

CREATE TABLE Cursa (
    codigo VARCHAR(5) NOT NULL,
    email VARCHAR(50) NOT NULL,
    data_inicio DATE NOT NULL
);
ALTER TABLE Cursa ADD CONSTRAINT cursa_pk PRIMARY KEY (email, codigo);

CREATE TABLE Leciona (
    codigo VARCHAR(5) NOT NULL,
    registro INTEGER NOT NULL
);
ALTER TABLE Leciona ADD CONSTRAINT leciona_pk PRIMARY KEY (codigo, registro);

CREATE TABLE Aluno (
    email VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone NUMERIC(13) NOT NULL
);
ALTER TABLE Aluno ADD CONSTRAINT aluno_pk PRIMARY KEY (email);

CREATE TABLE Professor (
    registro INTEGER NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone NUMERIC(13) NOT NULL
);
ALTER TABLE Professor ADD CONSTRAINT professor_pk PRIMARY KEY (registro);