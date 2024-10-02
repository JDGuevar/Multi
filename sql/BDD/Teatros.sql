create database Teatros;

use Teatros;

CREATE TABLE PERSONAL (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    teléfono VARCHAR(20)
);

CREATE TABLE ACTOR (
    id INT PRIMARY KEY,
    edad INT,
    FOREIGN KEY (id) REFERENCES PERSONAL(id)
);

CREATE TABLE TÉCNICO (
    id INT PRIMARY KEY,
    tarea VARCHAR(50),
    FOREIGN KEY (id) REFERENCES PERSONAL(id)
);

CREATE TABLE DIRECTOR (
    id INT PRIMARY KEY,
    dirección VARCHAR(200),
    nacionalidad VARCHAR(20),
    biografía TEXT,
    FOREIGN KEY (id) REFERENCES PERSONAL(id)
);

CREATE TABLE OBRAS (
    id INT PRIMARY KEY,
    director INT,
    título VARCHAR(200),
    autor VARCHAR(50),
    coste_de_implementación DECIMAL(10,2),
    tipo VARCHAR(20),
    género VARCHAR(20),
    FOREIGN KEY (director) REFERENCES DIRECTOR(id)
);
-- obras_actor
CREATE TABLE PERSONAJES (
    actor INT,
    obra INT,
    nombre VARCHAR(50),
    rol VARCHAR(20),
    FOREIGN KEY (actor) REFERENCES ACTOR(id),
    FOREIGN KEY (obra) REFERENCES OBRAS(id),
    PRIMARY KEY (actor, obra)
);

CREATE TABLE OBRAS_TÉCNICO (
    obra INT,
    técnico INT,
    FOREIGN KEY (obra) REFERENCES OBRAS(id),
    FOREIGN KEY (técnico) REFERENCES TÉCNICO(id),
    PRIMARY KEY (obra, técnico)
);

CREATE TABLE TEATRO (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    dirección VARCHAR(200),
    ciudad VARCHAR(50),
    capacidad INT,
    categoría VARCHAR(20)
);


CREATE TABLE FUNCIÓN (
    teatro INT,
    date_time DATETIME,
    obra INT,
    FOREIGN KEY (teatro) REFERENCES TEATRO(id),
    FOREIGN KEY (obra) REFERENCES OBRAS(id),
    PRIMARY KEY (teatro, date_time, obra)
);

CREATE TABLE TIPO_ASIENTO (
    tipo_asiento VARCHAR(20) PRIMARY KEY,
    precio DECIMAL(10,2)
);

CREATE TABLE TIQUET (
    num_asiento INT,
    teatro INT,
    date_time DATETIME,
    tipo_asiento VARCHAR(20),
    FOREIGN KEY (tipo_asiento) REFERENCES TIPO_ASIENTO(tipo_asiento),
    FOREIGN KEY (teatro, date_time) REFERENCES FUNCIÓN(teatro, date_time)
);

INSERT INTO PERSONAL (id, nombre, teléfono) VALUES
(1, 'Juan Perez', '1234567890'),
(2, 'María López', '0987654321'),
(3, 'Carlos Rodríguez', '1357902468'),
(4, 'Ana Martínez', '9876543210'),
(5, 'Pedro García', '5432167890'),
(6, 'Laura Sánchez', '0987654321'),
(7, 'Luis Ramirez', '9876543210'),
(8, 'Sofía Gómez', '1234567890'),
(9, 'David Torres', '5432167890'),
(10, 'Elena Castro', '0987654321'),
(11, 'Miguel Ángel', '1234567890'),
(12, 'Rosa García', '0987654321'),
(13, 'Javier Fernández', '1357902468'),
(14, 'Carmen Martínez', '9876543210'),
(15, 'Roberto Sánchez', '5432167890'),
(16, 'Marina Gómez', '0987654321'),
(17, 'José Luis Ramírez', '9876543210'),
(18, 'Isabel Torres', '1234567890'),
(19, 'Eduardo Castro', '5432167890'),
(20, 'Laura Pérez', '0987654321'),
(21, 'Santiago López', '1234567890'),
(22, 'Ana Rodríguez', '0987654321'),
(23, 'Diego Sánchez', '5432167890'),
(24, 'Lucía García', '0987654321'),
(25, 'Juan Manuel Fernández', '1234567890'),
(26, 'Silvia Martínez', '0987654321'),
(27, 'Pedro Gómez', '5432167890'),
(28, 'Natalia Ramírez', '0987654321'),
(29, 'Ricardo Torres', '1234567890'),
(30, 'Elena Castro', '5432167890');

INSERT INTO ACTOR (id, edad) VALUES
(1, 30),
(2, 25),
(3, 35),
(4, 28),
(5, 32),
(6, 27),
(7, 29),
(8, 31),
(9, 26),
(10, 33);

INSERT INTO TÉCNICO (id, tarea) VALUES
(11, 'Iluminación'),
(12, 'Sonido'),
(13, 'Escenografía'),
(14, 'Vestuario'),
(15, 'Maquillaje'),
(16, 'Reparaciones'),
(17, 'Montaje'),
(18, 'Diseño'),
(19, 'Producción'),
(20, 'Coordinación');

INSERT INTO DIRECTOR (id, dirección, nacionalidad, biografía) VALUES
(21, 'Calle Mayor, 123', 'Español', 'Director con experiencia en teatro y cine.'),
(22, 'Avenida Libertador, 456', 'Mexicano', 'Director de reconocida trayectoria en obras de teatro.'),
(23, 'Broadway Street, 789', 'Estadounidense', 'Director ganador de premios Tony.'),
(24, 'Rue de la République, 321', 'Francés', 'Director de teatro contemporáneo muy innovador.'),
(25, 'Piazza del Duomo, 456', 'Italiano', 'Director de ópera y teatro clásico.'),
(26, 'Kurfürstendamm, 987', 'Alemán', 'Director conocido por sus montajes vanguardistas.'),
(27, 'Rua Augusta, 654', 'Portugués', 'Director comprometido con la inclusión y diversidad en el teatro.'),
(28, 'Gran Vía, 789', 'Argentino', 'Director con una visión única y audaz.'),
(29, 'Shibuya Crossing, 123', 'Japonés', 'Director influyente en el teatro experimental.'),
(30, 'Kensington High Street, 456', 'Británico', 'Director versátil con experiencia en diversos géneros.');

INSERT INTO OBRAS (id, director, título, autor, coste_de_implementación, tipo, género) VALUES
(101, 21, 'Hamlet', 'William Shakespeare', 15000.00, 'Drama', 'Tragedia'),
(102, 22, 'La Casa de Bernarda Alba', 'Federico García Lorca', 12000.00, 'Drama', 'Tragedia'),
(103, 23, 'El Fantasma de la Ópera', 'Andrew Lloyd Webber', 20000.00, 'Musical', 'Fantasía'),
(104, 24, 'Esperando a Godot', 'Samuel Beckett', 10000.00, 'Drama', 'Absurdo'),
(105, 25, 'La Traviata', 'Giuseppe Verdi', 25000.00, 'Ópera', 'Romántica'),
(106, 26, 'La Casa de los Espíritus', 'Isabel Allende', 18000.00, 'Drama', 'Realismo mágico'),
(107, 27, 'Romeo y Julieta', 'William Shakespeare', 17000.00, 'Drama', 'Romance'),
(108, 28, 'Bodas de Sangre', 'Federico García Lorca', 13000.00, 'Drama', 'Tragedia'),
(109, 29, 'Kabuki', 'Tradición Japonesa', 22000.00, 'Teatro Tradicional', 'Cultural'),
(110, 30, 'El Rey Lear', 'William Shakespeare', 16000.00, 'Drama', 'Tragedia');

INSERT INTO PERSONAJES (actor, obra, nombre, rol) VALUES
(1, 101, 'Hamlet', 'Protagonista'),
(2, 102, 'Bernarda Alba', 'Protagonista'),
(3, 103, 'Fantasma', 'Protagonista'),
(4, 104, 'Estragón', 'Protagonista'),
(5, 105, 'Violetta', 'Protagonista'),
(6, 106, 'Clara', 'Protagonista'),
(7, 107, 'Romeo', 'Protagonista'),
(8, 108, 'Leonardo', 'Protagonista'),
(9, 109, 'Kabuki Actor', 'Protagonista'),
(10, 110, 'Lear', 'Protagonista');

INSERT INTO OBRAS_TÉCNICO (obra, técnico) VALUES
(101, 11),
(102, 12),
(103, 13),
(104, 14),
(105, 15),
(106, 16),
(107, 17),
(108, 18),
(109, 19),
(110, 20);

INSERT INTO TEATRO (id, nombre, dirección, ciudad, capacidad, categoría) VALUES
(201, 'Teatro Municipal', 'Calle Mayor, 456', 'Madrid', 500, 'Municipal'),
(202, 'Gran Teatro', 'Avenida Libertador, 789', 'México DF', 800, 'Municipal'),
(203, 'Broadway Theater', 'Broadway Street, 123', 'Nueva York', 1000, 'Comercial'),
(204, 'Théâtre de la République', 'Rue de la République, 654', 'París', 700, 'Nacional'),
(205, 'Teatro alla Scala', 'Piazza del Duomo, 789', 'Milán', 1200, 'Nacional'),
(206, 'Deutsches Theater', 'Kurfürstendamm, 321', 'Berlín', 900, 'Nacional'),
(207, 'Teatro Nacional Dona Maria II', 'Rua Augusta, 456', 'Lisboa', 600, 'Nacional'),
(208, 'Teatro Colón', 'Gran Vía, 987', 'Buenos Aires', 1500, 'Nacional'),
(209, 'Kabukiza Theater', 'Shibuya Crossing, 456', 'Tokio', 1000, 'Nacional'),
(210, 'Royal Albert Hall', 'Kensington High Street, 789', 'Londres', 2000, 'Municipal');

INSERT INTO TIPO_ASIENTO (tipo_asiento, precio) VALUES
('VIP', 100.00),
('Premium', 80.00),
('General', 50.00),
('Estudiante', 30.00),
('Tercera Edad', 30.00);

INSERT INTO FUNCIÓN (teatro, date_time, obra) VALUES
(201, '2024-04-01 18:00:00', 101),
(202, '2024-04-02 20:00:00', 102),
(203, '2024-04-03 19:30:00', 103),
(204, '2024-04-04 17:00:00', 104),
(205, '2024-04-05 21:00:00', 105),
(206, '2024-04-06 18:30:00', 106),
(207, '2024-04-07 19:00:00', 107),
(208, '2024-04-08 20:30:00', 108),
(209, '2024-04-09 18:00:00', 109),
(210, '2024-04-10 20:00:00', 110);

INSERT INTO TIQUET (num_asiento, teatro, date_time, tipo_asiento) VALUES
(1, 201, '2024-04-01 18:00:00', 'VIP'),
(2, 201, '2024-04-01 18:00:00', 'Premium'),
(3, 201, '2024-04-01 18:00:00', 'General'),
(4, 202, '2024-04-02 20:00:00', 'VIP'),
(5, 202, '2024-04-02 20:00:00', 'Premium'),
(6, 202, '2024-04-02 20:00:00', 'General'),
(7, 203, '2024-04-03 19:30:00', 'VIP'),
(8, 203, '2024-04-03 19:30:00', 'Premium'),
(9, 203, '2024-04-03 19:30:00', 'General'),
(10, 204, '2024-04-04 17:00:00', 'VIP');

