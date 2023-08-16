CREATE TABLE Queimada (
Tipo_Queimada INT NOT NULL,
Descricao VARCHAR(255),
Ativo BOOLEAN NOT NULL,
CatastrofeId INT NOT NULL,
FOREIGN KEY(CatastrofeId) REFERENCES Catastrofe(Sequencial));