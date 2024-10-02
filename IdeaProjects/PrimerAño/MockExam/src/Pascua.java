public class Pascua {

    //CODIGO RECICLADO

    static int dia, mes, any; // reciclando los nombres de las variables del programa de calendario.

    static int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // fragmento reciclado que indica los dias que posee cada mes.

    static boolean dataCorrecta(int dia, int mes, int any){ //función que comprueba que la fecha introducida es una fecha real dentro del rango.
        if (any < 1 || (mes < 1 || mes > 12) || (dia < 1 || dia > diesMes[mes - 1])){
            System.err.println("Data incorrecta");
            return false;
        }
        return true;
    }

    static int diasemana(int dia, int mes, int any){ //función que indica el día de la semana de la fecha introducida.
        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7; //0: Lunes, 1: Martes, 2: Miercoles, 3: Jueves, 4: Viernes, 5: Sabado, 6: Domingo.
    }

    //CODIGO PROPIO

    static int domingo(int dia, int diasemana){ //hace uso de la anterior función para indicar cuando es domingo.
        int suma = (diasemana - 6) * (-1); //decidí hacer uso de una resta de 6 y multiplicación por menos 1 para saber la distancia con el domingo.
    //esta decisión tiene como consecuencia que al introducir un dia domingo, se mantenga la fecha introducidad.
        dia = dia + suma;

        if (dia > diesMes[mes - 1]){ // una serie de if unicamente para cuando el domingo de esa semana caiga un mes o un año siguiente.
            dia = dia - diesMes[mes - 1];
            if (++mes > 12){
                mes -= 12;
                any += 1;
            }
        }

        return dia;

    }

    public static void main(String[] args) {

        if (args.length != 3) //control de flujo.
        {
            System.out.println("Debes de introducir una fecha en formato: dd mm yyyy");
            System.exit(2);
        }

        //DEFINICIÓN DE VARIABLES.

        try { //solo metí las definiciones de variables en el try por pura comodidad.
            dia = Integer.parseInt(args[0]);
            mes = Integer.parseInt(args[1]);
            any = Integer.parseInt(args[2]);
        }catch (NumberFormatException e){
            System.err.println("Introduce solo valores numéricos enteros");
            System.exit(1);
        }


        //CORRECCIONES Y EJECUCIÓN DEL PROGRAMA

        if (!dataCorrecta(dia,mes,any)) System.exit(3); //aquí se evalua si la fecha introducida es correcta.

        if ( ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0) ) diesMes[1] = 29; //esta linea comprueba si es año bisiesto.

        //System.out.println(diasemana(dia,mes,any)); comprobando que suelta el dia de la semana correcto.

        System.out.println("El siguiente domingo tiene fecha: " + domingo(dia, diasemana(dia, mes, any)) + " " + mes + " " + any);

    }
}
