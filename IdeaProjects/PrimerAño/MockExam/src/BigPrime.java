import java.math.BigInteger;
import java.util.Arrays;
public class BigPrime {
    public BigPrime(int target){ //target indica hasta qué número se buscarán los números primos Marsenne
        int[] numbers = new int [target];
        Arrays.fill(numbers, 1);

        for (int i = 3; i < target; i+=2)
            if (numbers[i] != 0){
                test(i);
                for (int j = i; j < target; j += i) numbers[j] = 0;
            }
    }

    void test (int exponent){ //exponente representa el numero p al que se le realizará el test de primalidad
        BigInteger candidate = BigInteger.TWO.pow(exponent).subtract(BigInteger.ONE);// candidato es un número de Mersenne, esta linea significa (2^p) - 1 ya que así se calculan los p-esimos de Mersenne
        BigInteger tester = BigInteger.valueOf(4); //Tester es el primer número S de valor 4 con el que calcularemos el resto de números S para la primalidad de los números de Mersenne

        for (int i = 1; i <= exponent - 2; i++) //calcula el número S necesario para comprobar la primalidad
            tester = tester.pow(2).subtract(BigInteger.TWO).mod(candidate);//parte de la formula de S(n) = (S(n-1))² - 2


        if (tester.compareTo(BigInteger.ZERO) == 0) // si el número S(p-1) tiene una distancia hacia 0 divisible por el candidato entonces el candidato es primo
            System.out.println(exponent + " -> " + candidate);
        else
            System.out.printf("%d\r", exponent);
    }

    public static void main(String[] args) {
        new BigPrime(20000);
    }
}
