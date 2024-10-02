package binary;

public class Experimental extends PixMap{
    public Experimental(){
        super(800,600,"experimental");
        Print();
    }
    public int[] color(int w, int h){
        return new int[]{0x33,0x66,0x99};
    }
}
