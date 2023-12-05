CREATE TYPE topicA AS ENUM('Euros', 'Dollar', 'Ariary', 'Other');
CREATE TYPE topicB AS ENUM('€ur','$','MGA','Other');
CREATE TABLE if not exists Devises(
  id_devise int primary key,
  nom_devise topicA,
  symbole_devise topicB,
);