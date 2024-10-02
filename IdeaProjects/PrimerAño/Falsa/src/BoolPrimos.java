public class BoolPrimos
{
    public static void main(String[] args)
    {
        int primos = 0; //Contador de primos

        for (int numero = 2 ; primos < 10 ; numero++) //Aquí y solo aquí se dicta cuantos primos ha de buscar
        {
            boolean flag = true; //Cambia su valor si el número es par

            for (int factor = 2; factor < numero && flag; factor++) //Prueba si un número es par
            {
                flag = !(numero % factor == 0); //Cambia el valor del comprobante
            }
            if (flag)
            {
                System.out.println(numero); //Muestra el número primo
                primos++; //Suma al contador de primos
            }
        }
    }
}