import java.io.Serializable;

public class Data  implements Serializable {
    private static final long serialVersion = 19640416L;
    private int[] number5strip;
    public Data(int size){
        number5strip = new int[size];

        for (int i = 0; i < number5strip.length; i++){
            number5strip[i] = 2 * i + 1;
        }
    }

    public String toString(){
        String result = "|";
        for (int i = 0; i < number5strip.length; i++){
            result += String.format("%d|", number5strip[i]);

        }
        return result;
    }

}
