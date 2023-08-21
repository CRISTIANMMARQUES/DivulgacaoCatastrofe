CREATE TABLE noticia(
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(150),
    AgenciaID VARCHAR(50) NOT NULL,
    CatastrofeID INT NOT NULL,
    GrauUrgencia CHAR NOT NULL,
    DataHora TIMESTAMP NOT NULL,
    FOREIGN KEY (AgenciaID) REFERENCES Agencia(cnpj),
    FOREIGN KEY (CatastrofeID) REFERENCES Catastrofe(sequencial));