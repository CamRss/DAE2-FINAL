drop database bdcolegioeuler;
CREATE DATABASE bdcolegioeuler;
USE bdcolegioeuler;

-- Tabla Profesor
CREATE TABLE Profesor (
	CodProfesor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Dni CHAR(8) NOT NULL,
	Nombre VARCHAR(40) NOT NULL,
	ApellidoPaterno VARCHAR(60) NOT NULL,
	ApellidoMaterno VARCHAR(60) NOT NULL,
	FechaNacimiento varchar(30) NOT NULL,
	CorreoElectronico VARCHAR(80) NOT NULL,
	Telefono CHAR(9) NOT NULL,
	Especialidad VARCHAR(40) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla Horario
CREATE TABLE Horario (
	CodHorario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DiasDictado VARCHAR(50) NOT NULL,
	HoralInicio varchar(20) NOT NULL,
	HoralFin varchar(20) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla Sede
CREATE TABLE Sede (
	CodSede INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Nombre VARCHAR(30) NOT NULL,
	Direccion VARCHAR(60) NOT NULL,
	Estado BOOLEAN NOT NULL
);

-- Tabla Aula
CREATE TABLE Aula (
	CodAula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Piso VARCHAR(2) NOT NULL,
	Descripcion VARCHAR(50) NOT NULL,
	Aforo int NOT NULL,
	CodSede INT NOT NULL,
    Estado BOOLEAN NOT NULL,
	FOREIGN KEY (CodSede) REFERENCES Sede(CodSede)
);

-- Tabla Curso
CREATE TABLE Curso (
	CodCurso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Nombre VARCHAR(50) NOT NULL,
	Descripcion VARCHAR(100) NOT NULL,
	Modalidad CHAR(1) NOT NULL,
	FechaInicio varchar(50) NOT NULL,
	FechaFin varchar(50) NOT NULL,
	CodAula INT NOT NULL,
	CodProfesor INT NOT NULL,
	CodHorario INT NOT NULL,
    Estado BOOLEAN NOT NULL,
	FOREIGN KEY (CodAula) REFERENCES Aula(CodAula),
	FOREIGN KEY (CodProfesor) REFERENCES Profesor(CodProfesor),
	FOREIGN KEY (CodHorario) REFERENCES Horario(CodHorario)
);

-- Tabla Alumno
CREATE TABLE Alumno (
	CodAlumno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Dni CHAR(8) NOT NULL,
	Nombre VARCHAR(40) NOT NULL,
	ApellidoPaterno VARCHAR(60) NOT NULL,
	ApellidoMaterno VARCHAR(60) NOT NULL,
	FechaNacimiento varchar(50) NOT NULL,
	Telefono CHAR(9) NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Tabla Matricula
CREATE TABLE Matricula (
	CodMatricula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	FechaMatricula varchar(50) NOT NULL,
	Estado BOOLEAN NOT NULL,
	CodAlumno INT NOT NULL,
	CodCurso INT NOT NULL,
	FOREIGN KEY (CodAlumno) REFERENCES Alumno(CodAlumno),
	FOREIGN KEY (CodCurso) REFERENCES Curso(CodCurso)
);

-- Insert data into Profesor table
INSERT INTO Profesor (Dni, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, CorreoElectronico, Telefono, Especialidad, Estado)
VALUES
('12345678', 'Juan', 'Pérez', 'García', '1975-05-15', 'juan.perez@example.com', '987654321', 'Mathematics', TRUE),
('23456789', 'Maria', 'Lopez', 'Martinez', '1980-09-22', 'maria.lopez@example.com', '987123456', 'Physics', TRUE),
('34567890', 'Carlos', 'Ramirez', 'Sanchez', '1985-12-10', 'carlos.ramirez@example.com', '987654789', 'Chemistry', TRUE),
('45678901', 'Ana', 'Gonzalez', 'Fernandez', '1990-07-30', 'ana.gonzalez@example.com', '987321654', 'Biology', TRUE),
('56789012', 'Luis', 'Hernandez', 'Ruiz', '1978-04-25', 'luis.hernandez@example.com', '987654987', 'History', TRUE);

-- Insert data into Horario table
INSERT INTO Horario (DiasDictado, HoralInicio, HoralFin, Estado)
VALUES
('Monday, Wednesday', '08:00:00', '10:00:00', TRUE),
('Tuesday, Thursday', '10:00:00', '12:00:00', TRUE),
('Monday, Friday', '14:00:00', '16:00:00', TRUE),
('Wednesday, Friday', '16:00:00', '18:00:00', TRUE),
('Tuesday, Thursday', '08:00:00', '10:00:00', TRUE);

-- Insert data into Sede table
INSERT INTO Sede (Nombre, Direccion, Estado)
VALUES
('Main Campus', '123 Main St', TRUE),
('North Campus', '456 North Ave', TRUE),
('East Campus', '789 East Rd', TRUE),
('West Campus', '321 West St', TRUE),
('South Campus', '654 South Blvd', TRUE);

-- Insert data into Aula table
INSERT INTO Aula (Piso, Descripcion, Aforo, CodSede, Estado)
VALUES
('1', 'Room A', 30, 1, TRUE),
('2', 'Room B', 25, 2, TRUE),
('3', 'Room C', 20, 3, TRUE),
('1', 'Room D', 35, 4, TRUE),
('2', 'Room E', 40, 5, TRUE);

-- Insert data into Curso table
INSERT INTO Curso (Nombre, Descripcion, Modalidad, FechaInicio, FechaFin, CodAula, CodProfesor, CodHorario, Estado)
VALUES
('Calculus', 'Introduction to Calculus', 'P', '2024-01-15', '2024-06-15', 1, 1, 1, TRUE),
('Physics I', 'Basic principles of Physics', 'P', '2024-02-01', '2024-07-01', 2, 2, 2, TRUE),
('Chemistry I', 'Basic concepts of Chemistry', 'P', '2024-03-01', '2024-08-01', 3, 3, 3, TRUE),
('Biology I', 'Introduction to Biology', 'P', '2024-04-01', '2024-09-01', 4, 4, 4, TRUE),
('World History', 'History of civilizations', 'P', '2024-05-01', '2024-10-01', 5, 5, 5, TRUE);

-- Insert data into Alumno table
INSERT INTO Alumno (Dni, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Telefono, Estado)
VALUES
('87654321', 'Pedro', 'Diaz', 'Rodriguez', '2000-02-14', '987123789', TRUE),
('76543210', 'Lucia', 'Ortiz', 'Gomez', '1999-07-18', '987654123', TRUE),
('65432109', 'Miguel', 'Torres', 'Vega', '1998-11-25', '987321789', TRUE),
('54321098', 'Laura', 'Rojas', 'Paredes', '2001-03-10', '987654321', TRUE),
('43210987', 'Sofia', 'Medina', 'Mendoza', '2002-06-21', '987321654', TRUE);

-- Insert data into Matricula table
INSERT INTO Matricula (FechaMatricula, Estado, CodAlumno, CodCurso)
VALUES
('2024-01-10 08:00:00', TRUE, 1, 1),
('2024-02-05 09:00:00', TRUE, 2, 2),
('2024-03-10 10:00:00', TRUE, 3, 3),
('2024-04-15 11:00:00', TRUE, 4, 4),
('2024-05-20 12:00:00', TRUE, 5, 5);

