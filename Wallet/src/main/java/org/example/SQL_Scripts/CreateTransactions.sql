CREATE TABLE IF NOT EXISTS Transactions(
id_transaction int primary key,
id_devise int REFERENCES Devises(id_devise),
id_compte int REFERENCES Comptes(id_compte),
montant FLOAT,
type_transaction VARCHAR(100),
date_transaction DATE
);
