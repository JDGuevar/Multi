public class Node {
    private int edad;
    Node next;

    public Node(int edad){
        this.edad = edad;
        this.next = null;
    }

    public int getEdad() {
        return edad;
    }

    public Node getNext() {
        return next;
    }

    public void setEdad(int eda) {
        this.edad = edad;
    }
}
