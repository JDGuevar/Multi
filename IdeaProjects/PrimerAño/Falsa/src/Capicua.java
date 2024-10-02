public class Capicua {
    public static void main(String[] args)
    {
        if(args.length != 1){ // Control de flujo, solo se debe introducir un argumento.
            System.err.println("Debes introducir un único número entero");
            System.exit(1);
        }

        String num = args[0];

        for (int i = 0; i < num.length(); i++){ // Control de flujo, solo números enteros.
            if (num.charAt(i) < '0' || num.charAt(i) > '9'){ //48 = 0, 57 = 9 en ASCII.
                System.err.println("El argumento introducido no es un número");
                System.exit(2);
            }
        }

        while (num.charAt(0) == '0' && num.length() != 1){ //chao los ceros a la izquierda.
            num = num.replaceFirst("0","");
        }

        System.out.println(num);

        if (Flag(num)) System.out.println("Es Capicua");
        else System.out.println("No es Capicua");

    }
    public static boolean Flag(String x){
        for (int i = 0; i < (x.length() / 2); i++ ) // solo la mitad de la longitud para comparar la ultima y primera posición progresivamente.
        {
            if (x.charAt(i) != x.charAt(x.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }
}

/*
1 Qui és el propòsit del mètode public static void main(String[] args) a Java?
a) Declarar variables
b) Iniciar l’aplicació -->(Respuesta Correcta)
c) Imprimir missatges a la consola
d) Definir mètodes

2 Com es declara una variable de tipus enter a Java?
a) variable x;
b) int x; -->(Respuesta Correcta)
c) nova variable x;
d) crear int x;

3 Quina és la paraula clau utilitzada per definir una constant a Java?
a) constant
b) final -->(Respuesta Correcta)
c) const
d) immutable

4 Com es llegeix un número enter des del teclat a Java?
a) read()
b) getInput()
c) Scanner -->(Respuesta Correcta con la función Scanner.nextInt(). Es una libreria de Java que permite leer entradas cuando ya se ha iniciado el programa)
d) inputStream

5 Quin és el resultat del codi següent?
{
int x = 5;
int y = 2;
System.out.println(x / y);
}
a) 2.5
b) 2 -->(Respuesta Correcta. Ya que la variable int solo imprime números enteros, eliminando el .5 que quedaría)
c) 2.0
d) 2.2

6 Quina és la forma correcta d’escriure un bucle for que imprimeixi els números de l’1 al 10?
a) for (int i = 1; i <= 10; i++)-->(Respuesta Correcta si System.out.print(i))
b) for (int i = 1; i < 11; i++)-->(Respuesta Correcta si System.out.print(i))
c) for (int i = 1; i < 10; i++)
d) for (int i = 0; i <= 9; i++)-->(Respuesta Correcta si System.out.print(i+1))

7 Com es fa un comentari d’una sola línia a Java?
a) // Comentari -->(Respuesta Correcta)
b) /* Comentari *//* -->(Con este también se puede comentar una linea si se cierra en la misma) (P.D: esto me ha obligado a abrir de nuevo el comentario justo despues)
c) # Comentari
d) -- Comentari

8 Quin és el resultat de la següent expressió lògica?
{
boolean a = true;
boolean b = false;
System.out.println(a && b || !a);
}
a) true
b) false -->(Respuesta Correcta. a && b comprueba si a y b son true, pero solo lo es a. !a comprueba si a es false y tampoco lo es. Por tanto imprime false)
c) Error de compilació
d) No es pot determinar

9 Què és un bucle while a Java?
a) Una variable
b) Un bloc de codi -->(Puede estar dentro de un bloque de código o conformar el bloque entero)
c) Una constant
d) Una estructura de control -->(Respuesta Correcta)

10 Com s’imprimeix un missatge a la consola Java?
a) print("Hola");
b) System.out("Hola");
c) console.log("Hola");
d) System.out.println("Hola"); -->(Respuesta Correcta)

*/