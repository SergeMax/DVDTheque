DROP DATABASE IF EXISTS DVDTHEQUE;
CREATE DATABASE DVDTHEQUE;

CREATE TABLE DVDTHEQUE.Realisateur(
        Id_Realisateur   Int Auto_increment NOT NULL PRIMARY KEY,
        Nom_Realisateur      Varchar (50) NOT NULL,
        Prenom_Realisateur   Varchar (50) NOT NULL
);

CREATE TABLE DVDTHEQUE.Nationnalite(
        Id_Nationnalite   Int Auto_increment NOT NULL PRIMARY KEY,
        Libelle_Nationnalite      Varchar (250) NOT NULL
);

CREATE TABLE DVDTHEQUE.Film(
        Id_Film     Int  Auto_increment  NOT NULL PRIMARY KEY,
        Nom_Film    Varchar (50) NOT NULL,
        Annee_Film  Int (250) NOT NULL,
        Note_Film   Int (250) NOT NULL,
        Resume_Film Varchar (500) NOT NULL,
        Image_Film  Varchar (250) NOT NULL,
        Realisateur_id int,
        Nationnalite_id int,
        CONSTRAINT fkRealFilm FOREIGN KEY (Realisateur_id) REFERENCES Realisateur(Id_Realisateur),
        CONSTRAINT fkNationnaliteFilm FOREIGN KEY (Nationnalite_id) REFERENCES Nationnalite(Id_Nationnalite)
);

CREATE TABLE DVDTHEQUE.Acteur(
        Id_Acteur       Int Auto_increment NOT NULL PRIMARY KEY,
        Nom_Acteur      Varchar (50) NOT NULL,
        Prenom_Acteur   Varchar (50) NOT NULL
);


CREATE TABLE DVDTHEQUE.Genre(
        Id_Genre        Int Auto_increment NOT NULL PRIMARY KEY,
        Libelle_Genre   Varchar (50) NOT NULL
);

CREATE TABLE DVDTHEQUE.Film_Acteur(
        Film_id    Int,
        Acteur_id   Int,
        PRIMARY KEY(Film_id,Acteur_id),
        CONSTRAINT fkFilmActeur1 FOREIGN KEY (Film_id) REFERENCES Film(Id_Film) ON DELETE CASCADE,
        CONSTRAINT fkFilmActeur2 FOREIGN KEY (Acteur_id) REFERENCES Acteur(Id_Acteur) ON DELETE CASCADE
);

CREATE TABLE DVDTHEQUE.Film_Genre(
        Film_id    Int,
        Genre_id   Int,
        PRIMARY KEY(Film_id,Genre_id),
        CONSTRAINT fkFilmGenre1 FOREIGN KEY (Film_id) REFERENCES Film(Id_Film) ON DELETE CASCADE,
        CONSTRAINT fkFilmGenre2 FOREIGN KEY (Genre_id) REFERENCES Genre(Id_Genre) ON DELETE CASCADE
);

INSERT INTO DVDTHEQUE.Realisateur VALUES (1, 'pablo', 'juju');
INSERT INTO DVDTHEQUE.Realisateur VALUES (2, 'Foufou', 'steve');
INSERT INTO DVDTHEQUE.Realisateur VALUES (3, 'Roulio', 'Mimi');


INSERT INTO DVDTHEQUE.Nationnalite VALUES (1, 'Francaise');
INSERT INTO DVDTHEQUE.Nationnalite VALUES (2, 'English');
INSERT INTO DVDTHEQUE.Nationnalite VALUES (3, 'Kabil');





INSERT INTO DVDTHEQUE.genre (Libelle_Genre) VALUES ('Action');
INSERT INTO DVDTHEQUE.genre (Libelle_Genre) VALUES ('Aventure');
INSERT INTO DVDTHEQUE.genre (Libelle_Genre) VALUES ('Horreur');
INSERT INTO DVDTHEQUE.genre (Libelle_Genre) VALUES ('S-F');
INSERT INTO DVDTHEQUE.genre (Libelle_Genre) VALUES ('Romantisme');





INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('CInquieme Element', 1990, 5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerc', 'assets/image/5elem.png', 1, 1);

INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('Kill', 2000, 5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerc', 'assets/image/Kill.png', 1, 1);

INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('Titanic', 2020, 3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerc', 'assets/image/titanic.png', 1, 1);

INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('Terre Abstraite', 1999, 4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerc', 'assets/image/terre.png', 1, 1);

INSERT INTO DVDTHEQUE.Film (Nom_Film, Annee_Film, Note_Film, Resume_Film, Image_Film, Realisateur_id, Nationnalite_id) VALUES ('Titanic', 2001, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exerc', 'assets/image/titanic.png', 1, 1);





INSERT INTO DVDTHEQUE.film_genre VALUES (1, 1);
INSERT INTO DVDTHEQUE.film_genre VALUES (1, 2);
INSERT INTO DVDTHEQUE.film_genre VALUES (2, 2);
INSERT INTO DVDTHEQUE.film_genre VALUES (2, 3);
INSERT INTO DVDTHEQUE.film_genre VALUES (2, 4);
INSERT INTO DVDTHEQUE.film_genre VALUES (3, 1);
INSERT INTO DVDTHEQUE.film_genre VALUES (4, 2);
INSERT INTO DVDTHEQUE.film_genre VALUES (4, 5);
INSERT INTO DVDTHEQUE.film_genre VALUES (5, 2);
INSERT INTO DVDTHEQUE.film_genre VALUES (5, 5);




INSERT INTO DVDTHEQUE.acteur (Nom_Acteur, Prenom_Acteur) VALUES ('Serge', 'Blanco');

INSERT INTO DVDTHEQUE.acteur (Nom_Acteur, Prenom_Acteur) VALUES ('Salim', 'Benbaouï');

INSERT INTO DVDTHEQUE.film_acteur VALUES (1, 1);
INSERT INTO DVDTHEQUE.film_acteur VALUES (1, 2);
INSERT INTO DVDTHEQUE.film_acteur VALUES (2, 2);
INSERT INTO DVDTHEQUE.film_acteur VALUES (2, 1);



