public class EhVielne {
    static int dia = 1, mes = 1, any; // reciclando los nombres de las variables del programa de calendario.

    static int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // fragmento reciclado que indica los dias que posee cada mes.

    static boolean dataCorrecta(int any){ //función que comprueba que la fecha introducida es una fecha real dentro del rango.
        if (any < 1){
            System.err.println("Data incorrecta");
            return false;
        }
        return true;
    }

    static int diasemana(int any){ //función que indica el día de la semana del primer dia del mes
        int a = (14 - 1) / 12;
        int y = any - a;
        int m = 1 + 12 * a - 2;
        int d = (1 + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7; //0: Lunes, 1: Martes, 2: Miercoles, 3: Jueves, 4: Viernes, 5: Sabado, 6: Domingo.
    }


    static int viernes1(int mes, int diasemana){
        int suma = ((diasemana - 6) * (-1) - 2);
        suma = 1 + suma;

        if (suma < 0) suma = suma + 7;

        return suma;
    }

    public static void main(String[] args) {

        if (args.length != 1) //control de flujo.
        {
            System.out.println("Debes de introducir una fecha en formato: dd mm yyyy");
            System.exit(2);
        }

        try {
            any = Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.err.println("Introduce solo valores numéricos enteros");
            System.exit(1);
        }

        if (!dataCorrecta(any)) System.exit(3);

        if ( ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0) ) diesMes[1] = 29;

        dia = viernes1(mes,diasemana(any));

        System.out.printf("%02d %02d %d\n", dia, mes, any);

        for (int i = 1; i <= 12; i++){
            mes = i;
            for (int j = 0; i == mes; j++){
                dia += 7;

                if (dia > diesMes[mes - 1]){
                    dia = dia - diesMes[mes - 1];
                    if (++mes > 12){
                        System.exit(7);
                    }
                }

                System.out.printf("%02d %02d %d\n", dia, mes, any);
            }
        }
    }
}
