CREATE TABLE Provincia (
    Id_prov INT PRIMARY KEY,    -- Id_prov como llave primaria
    Nombre NVARCHAR(255) UNIQUE -- Nombre debe ser único
);

CREATE TABLE oSexual (
    Id_sexual INT PRIMARY KEY,    -- Id_sexual como llave primaria
    Descripcion NVARCHAR(255) UNIQUE NOT NULL -- Descripción debe ser única y no nula
);

CREATE TABLE aPolitica (
    Id_poli INT PRIMARY KEY,    
    Nombre NVARCHAR(255) UNIQUE NOT NULL 
);

CREATE TABLE nAcademica (
    Id_acad INT PRIMARY KEY,    -- Id_acad como llave primaria
    Descripcion NVARCHAR(255) UNIQUE NOT NULL -- Descripción debe ser única y no nula
);

CREATE TABLE Persona (
    Id_perso INT IDENTITY(1,1) PRIMARY KEY,     
    Nombre NVARCHAR(255) NOT NULL,              
    Apell1 NVARCHAR(255) NOT NULL,              
    Apell2 NVARCHAR(255) NOT NULL,              
    Sexo CHAR(1) CHECK (Sexo IN ('F', 'M', 'O')) NOT NULL,  
    eCivil CHAR(1) CHECK (eCivil IN ('S', 'C', 'D', 'V', 'U')) NOT NULL,  
    Nacido DATE NOT NULL,                     
    Id_prov INT NOT NULL,                     
    Id_sexual INT NOT NULL,                   
    Id_poli INT NOT NULL,                      
    Id_acad INT NOT NULL,                     
    Salario DECIMAL(18,2) CHECK (Salario >= 0) NOT NULL, 

    -- Definiciones de claves foráneas
    FOREIGN KEY (Id_prov) REFERENCES Provincia(Id_prov),
    FOREIGN KEY (Id_sexual) REFERENCES oSexual(Id_sexual),
    FOREIGN KEY (Id_poli) REFERENCES aPolitica(Id_poli),
    FOREIGN KEY (Id_acad) REFERENCES nAcademica(Id_acad)
);