public class NPrimos
{
    public static void main(String[] args)
    {
        int primos = 0; //Contador de primos

        for (int numero = 2 ; primos < 10 ; numero++) //Aquí y solo aquí se dicta cuantos primos ha de buscar
        {
            int comprobante = 0; //Cambia su valor si el número es par

            for (int factor = 2; factor < numero && comprobante == 0; factor++) //Prueba si un número es par
            {
                if (numero % factor == 0)
                {
                    comprobante = 1; //Cambia el valor del comprobante
                }
            }
            if (comprobante == 0)
            {
                System.out.println(numero); //Muestra el número primo
                primos++; //Suma al contador de primos
            }
        }
    }
}
