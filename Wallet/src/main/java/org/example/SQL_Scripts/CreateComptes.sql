CREATE TABLE if not exists Comptes(
 id_compte int primary key,
 id_devise int REFERENCES Devises(id_devise),
 nom_compte VARCHAR(200),
 solde FLOAT,
 type_compte VARCHAR(100),
 date_ouverture DATE,
 proprietaire VARCHAR(200)
);