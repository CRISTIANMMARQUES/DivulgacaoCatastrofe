CREATE TABLE Vazamento_Nuclear (
Tipo_Vazamento_Nuclear INT NOT NULL,
Descricao VARCHAR(255),
Ativo BOOLEAN NOT NULL,
CatastrofeId INT NOT NULL,
FOREIGN KEY(CatastrofeId) REFERENCES Catastrofe(Sequencial));