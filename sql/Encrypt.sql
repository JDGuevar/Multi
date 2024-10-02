create database test;

use test;

delimiter //

create function encrypt(mensaje varchar(100), codi int) returns varchar(100)
deterministic
begin
declare final boolean default false;
declare charcont int default 1;
declare resultado varchar(100) default'';
declare caracter char(1);
bucle:loop
	if (char_length(mensaje) + 1 = charcont) then
    leave bucle;
    end if;
    set caracter = substring(mensaje, charcont, 1);
    set resultado = concat(resultado, char(ASCII(caracter) + codi));
    set charcont = charcont + 1;
end loop bucle;
return resultado;
end//

drop function encrypt//
select encrypt('DPOHSBUVMBUJPOT"!Zpv!bsf!uif!cftu"', -1)//

select encrypt('Facundo', -1)//


