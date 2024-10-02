public class Falsa
{
    public static void main(String[] args)
    {
        int a = 1, b = -3, c = 2; //Valores de la ecuación de segundo grado
        double x, y;

        if (a != 0) // primer término = 0 --> no es segundo grado
        {
          double d = (b * b) - (4.0 * a * c);
          double e = a + a;
          if ( d >= 0.0 ) //excluyendo el caso de los números complejos
          {
              x = (-b + Math.sqrt(d)) / e;
              y = (-b - Math.sqrt(d)) / e;

              System.out.println(x);
              System.out.println(y);
          }
          else // si el resultado es complejo
          {
              d = Math.sqrt(-d);

              x= -b / e;
              y= d / e ;

              System.out.println(x + "+" + y + "i");
              System.out.println(x + "-" + y + "i");
          }


        }
        else
        {
            System.out.println("no es de segundo grado");
            if (b!=0)
            {
                System.out.println( -c / b );
            }
            else
            {
                System.out.println((c!=0) ? "Ecuación incongruente" : "Ecuación trivial");
            }
        }
    }
}
