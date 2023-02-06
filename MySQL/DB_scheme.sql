DROP DATABASE IF EXISTS godb;
CREATE DATABASE IF NOT EXISTS godb;

USE godb;

CREATE TABLE GO_class(
Accession VARCHAR(100) NOT NULL unique,
Definition TEXT NOT NULL, 
Ontology_source VARCHAR(255) NOT NULL, 
PRIMARY KEY (Accession)
);


CREATE TABLE Gene_gnprod(
Symbol VARCHAR(255) NOT NULL, 
Name VARCHAR(255) NOT NULL, 
Organism VARCHAR(255) NOT NULL, 
gType VARCHAR(255) NOT NULL, 
Source VARCHAR(255) NOT NULL, 
Synonyms VARCHAR(255) NOT NULL,
PRIMARY KEY (Symbol)
);


CREATE TABLE Annotations(
Gene_Symbol VARCHAR(255) NOT NULL,
GO_class_Accession VARCHAR(100) NOT NULL, 
Organism VARCHAR(255) NOT NULL, 
Annotation_qualifier VARCHAR(255) NULL,
Annotation_extension VARCHAR(255) NULL,
Evidence VARCHAR(255) NULL,
Reference VARCHAR(255) NULL,
PRIMARY KEY (Gene_Symbol, GO_class_Accession),
FOREIGN KEY (Gene_Symbol) REFERENCES Gene_gnprod(Symbol),
FOREIGN KEY (GO_class_Accession) REFERENCES GO_class(Accession)
);
