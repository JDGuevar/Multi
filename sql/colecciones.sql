use biblioteca;
delimiter //

create function coleccion(code int) returns text
deterministic
begin
declare final boolean default false;
declare resultado text default concat('- ', (select colleccio from colleccions where ID_COL = code));
declare contador int default 1;
declare libro varchar(200) default '';
declare myCursor cursor for select titol from llibres where code = colleccio;
declare continue handler for not found set final = true;
open myCursor;
	bucle:loop
		fetch myCursor into libro;
		if final then 
        leave bucle;
        end if;
        set resultado = concat(resultado,'\n', ' ', contador, '. ', libro);
        set contador = contador + 1;
	end loop bucle;
close myCursor;
return resultado;
end //

delete from colleccions where ID_COL= 1//

drop function coleccion//

select coleccion(2)//

create procedure colecciones()
begin
declare final boolean default false;
declare resultado longtext default '';
declare col int;
declare myCursor cursor for select id_col from colleccions;
declare continue handler for not found set final = true;
open myCursor;
	bucle:loop
		fetch myCursor into col;
        if final then 
        leave bucle;
        end if;
        set resultado = concat(resultado, coleccion(col), '\n\n');
	end loop bucle;
close myCursor;

select resultado;
end//

drop procedure colecciones//

call colecciones//
