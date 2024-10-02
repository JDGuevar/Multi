public class List {

    private Node first;
    private Node last;
    private int length;

    public int getLength() {
        return length;
    }

    public void insert(int edad){
        Node work = new Node(edad);

        if (first == null) first = work;
         else last.next = work;

        last = work;
        length++;
    }

    public void delete(){
        if (isEmpty()) return;

        first = first.next;

        if (isEmpty()) last = null;

    }

    public void show(){
        if (isEmpty())  return;


        Node work = first;

        while (work != null){
            System.out.println(work.getEdad());
            work = work.next;
        }

        System.out.println(length + " element(s) in the list");
    }

    private boolean isEmpty(){
        boolean empty = first == null;

        if (empty){
            System.out.println("The list is empty");
        }

        return empty;
    }

    public void insertUnique(int age) {
        if (!isInList(age)) {
            insert(age);
        }
    }

    public boolean isInList(int edad) {
        Node work = first;
        while (work != null) {
            if (edad == (work.getEdad())) {
                return true;
            }
            work = work.next;
        }
        return false;
    }

    public boolean minorInList(int edad) {
        Node work = first;
        while (work != null) {
            if (edad > (work.getEdad())) {
                return true;
            }
            work = work.next;
        }
        return false;
    }

    public boolean mayorInList(int edad) {
        Node work = first;
        while (work != null) {
            if (edad < (work.getEdad())) {
                return true;
            }
            work = work.next;
        }
        return false;
    }

    public Node getFirst() {
        return first;
    }

}
