use teatros;

-- 1 mostrar el nombre del teatro y el número total de funciones programadas: aunque todos tienen solo 1
SELECT TEATRO.nombre, COUNT(FUNCIÓN.teatro) AS total_funciones
FROM TEATRO
LEFT JOIN FUNCIÓN ON TEATRO.id = FUNCIÓN.teatro
GROUP BY TEATRO.nombre;


-- 2 mostrar el nombre del director que ha dirigido más obras: aunque todos han dirigido solo una
SELECT PERSONAL.nombre AS nombre_director, COUNT(*) AS total_obras_dirigidas
FROM PERSONAL
JOIN DIRECTOR ON PERSONAL.id = DIRECTOR.id
JOIN OBRAS ON DIRECTOR.id = OBRAS.director
GROUP BY PERSONAL.nombre
ORDER BY total_obras_dirigidas DESC
LIMIT 1;

-- 3 mostrar el título de la obra más reciente en cada teatro: aunque todos tienen una sola obra
SELECT TEATRO.nombre, OBRAS.título AS obra_más_reciente
FROM TEATRO
LEFT JOIN (
    SELECT teatro, MAX(date_time) AS última_función
    FROM FUNCIÓN
    GROUP BY teatro
) AS ÚltimaFunción ON TEATRO.id = ÚltimaFunción.teatro
LEFT JOIN FUNCIÓN ON ÚltimaFunción.teatro = FUNCIÓN.teatro AND ÚltimaFunción.última_función = FUNCIÓN.date_time
LEFT JOIN OBRAS ON FUNCIÓN.obra = OBRAS.id;

-- 4 mostrar director y obra que dirige:
SELECT PERSONAL.nombre AS nombre_director, OBRAS.título
FROM PERSONAL
JOIN DIRECTOR ON PERSONAL.id = DIRECTOR.id
JOIN OBRAS ON DIRECTOR.id = OBRAS.director;

-- 5 mostrar el nombre del actor, el título de la obra en la que participa y el personaje que interpreta en esa obra.
SELECT PERSONAL.nombre AS nombre_actor, OBRAS.título, PERSONAJES.nombre as personaje
FROM PERSONAL
JOIN ACTOR ON PERSONAL.id = ACTOR.id
JOIN PERSONAJES ON ACTOR.id = PERSONAJES.actor
JOIN OBRAS ON PERSONAJES.obra = OBRAS.id;

-- 6 Listar todas las obras dirigidas por directores mexicanos junto con el nombre del teatro donde se llevaron a cabo:
SELECT OBRAS.título, TEATRO.nombre AS nombre_teatro
FROM DIRECTOR
JOIN OBRAS ON DIRECTOR.id = OBRAS.director
JOIN FUNCIÓN ON OBRAS.id = FUNCIÓN.obra
JOIN TEATRO ON FUNCIÓN.teatro = TEATRO.id
WHERE DIRECTOR.nacionalidad = 'Mexicano';

-- 7 Mostrar el nombre y la edad de los actores que interpretaron en la obra "Hamlet":
SELECT PERSONAL.nombre, ACTOR.edad
FROM PERSONAL
JOIN ACTOR ON PERSONAL.id = ACTOR.id
JOIN PERSONAJES ON ACTOR.id = PERSONAJES.actor
JOIN OBRAS ON PERSONAJES.obra = OBRAS.id
WHERE OBRAS.título = 'Hamlet';

-- 8 Listar el nombre y la tarea de los técnicos que trabajaron en la producción de "La Traviata":
SELECT PERSONAL.nombre, TÉCNICO.tarea
FROM PERSONAL
JOIN TÉCNICO ON PERSONAL.id = TÉCNICO.id
JOIN OBRAS_TÉCNICO ON TÉCNICO.id = OBRAS_TÉCNICO.técnico
JOIN OBRAS ON OBRAS_TÉCNICO.obra = OBRAS.id
WHERE OBRAS.título = 'La Traviata';

-- 9 Mostrar el nombre del teatro, el tipo de asiento y su precio para los tickets vendidos
SELECT TEATRO.nombre, TIPO_ASIENTO.tipo_asiento, TIPO_ASIENTO.precio
FROM TIPO_ASIENTO
JOIN TIQUET ON TIPO_ASIENTO.tipo_asiento = TIQUET.tipo_asiento
JOIN TEATRO ON TIQUET.teatro = TEATRO.id;

-- 10 mostrar las funciones de cada teatro
SELECT TEATRO.nombre, 
    (SELECT COUNT(*) FROM FUNCIÓN WHERE FUNCIÓN.teatro = TEATRO.id) AS total_funciones
FROM TEATRO;