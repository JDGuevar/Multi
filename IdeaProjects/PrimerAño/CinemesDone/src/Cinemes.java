import java.util.Random;

public class Cinemes {
    final int salas = 8;
    Random rand = new Random(888);

    public Cinemes(){
        int diaSemana = 4; //Que dia empieza el mes: 0 = lunes, 1 = martes, 2 = miercoles, 3 = jueves, 4 = viernes, 5 = sabado, 6 = domingo

        for (int i = 1; i <= 31; i++){
            if(diaSemana > 4){

            }

            diaSemana = (diaSemana + 1) % 7;
        }
    }

    private void session(){
        CinemaQueue q = new CinemaQueue(rand.nextInt(320,401));

        while (!q.full){
            int probabilitat = rand.nextInt(100);
            if (probabilitat < 10){
                if (rand.nextBoolean()){
                    q.insert(new Information(rand.nextInt(3), 0, rand.nextInt(20,31)));
                } else {
                    q.insert(new Information(rand.nextInt(3), rand.nextInt(20,31), 0));
                }
            }
            else {
                q.insert(new Information(rand.nextInt(2), rand.nextInt(3), rand.nextInt(3)));
            }
        }
    }
}
