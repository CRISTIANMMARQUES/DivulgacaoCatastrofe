CREATE TABLE Agencia(
	cnpj VARCHAR(100)NOT NULL,
	nome VARCHAR(60) NOT NULL,
	endereco VARCHAR(60),
	estado VARCHAR(5),
	país VARCHAR(5),
	tipo VARCHAR(1) NOT NULL,
        PRIMARY KEY (cnpj));