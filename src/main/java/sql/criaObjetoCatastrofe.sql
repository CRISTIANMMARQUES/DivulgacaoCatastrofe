INSERT INTO divulgacaocatastrofes.catastrofe (`Nome`, `Data`, `Localizacao`) 
	VALUES ('Inundação na avenida', '14/08/23', 'Dourados');
INSERT INTO divulgacaocatastrofes.inundacao (`Tipo_Inundacao`, `Descricao`, `Ativo`, `CatastrofeId`) 
	VALUES (2, 'Rua foi inundada, bueiros intopidos', false, 1);
INSERT INTO divulgacaocatastrofes.catastrofe (`Nome`, `Data`, `Localizacao`) 
	VALUES ('FOGO NO MORRO', '22/08/2023', 'Bela Vista');
INSERT INTO divulgacaocatastrofes.queimada (`Tipo_Queimada`, `Descricao`, `Ativo`, `CatastrofeId`) 
	VALUES (0, 'Houve incendio no morro margarida em epoca de seda.', true, 2);
INSERT INTO divulgacaocatastrofes.catastrofe (`Nome`, `Data`, `Localizacao`) 
	VALUES ('LIXO RADIOTIVO', '22/08/2023', 'BR 163 KM 14');
INSERT INTO divulgacaocatastrofes.vazamento_nuclear (`Tipo_Vazamento_Nuclear`, `Descricao`, `Ativo`, `CatastrofeId`) 
	VALUES (2, 'Caminhão carregado de rejeitos cadiotivos tomou na BR 163', true, 3);
