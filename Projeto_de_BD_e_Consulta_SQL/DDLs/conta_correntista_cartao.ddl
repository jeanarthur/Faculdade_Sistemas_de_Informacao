CREATE TABLE Conta (
    numero INTEGER NOT NULL,
    saldo NUMERIC(15, 2) NOT NULL,
    cpf VARCHAR(11) NOT NULL
);
ALTER TABLE Conta ADD CONSTRAINT conta_pk PRIMARY KEY (numero);

CREATE TABLE Cartao (
    numero INTEGER NOT NULL,
    senha VARCHAR(15) NOT NULL,
    emissao DATE NOT NULL,
    limite FLOAT NULL,
    data_validade DATE NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    numero_conta INTEGER NOT NULL
);
ALTER TABLE Cartao ADD CONSTRAINT cartao_pk PRIMARY KEY (numero);

CREATE TABLE Correntista (
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(70) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);
ALTER TABLE Correntista ADD CONSTRAINT correntista_pk PRIMARY KEY (cpf);