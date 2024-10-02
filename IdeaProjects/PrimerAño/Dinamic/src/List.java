public class List {

    private Node first;
    private Node last;
    private int length;

    public int getLength() {
        return length;
    }

    public void insert(String information){
        Node work = new Node(information);

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
            System.out.println(work.getInformation());
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

    public void insertUnique(String info) {
        if (!isInList(info)) {
            insert(info);
        }
    }

    public boolean isInList(String info) {
        Node work = first;
        while (work != null) {
            if (info.equals(work.getInformation())) {
                return true;
            }
            work = work.next;
        }
        return false;
    }

    public Node getFirst() {
        return first;
    }

    public void sort() {
        if (first == null) {
            return;
        }

        Node work = first.next;
        Node prev;

        while (work != null) {
            String tempInfo = work.getInformation();
            prev = first;

            while (prev != work && prev.getInformation().compareTo(tempInfo) <= 0) {
                prev = prev.next;
            }

            if (prev != work) {
                while (prev != work) {
                    String temp = prev.getInformation();
                    prev.setInformation(tempInfo);
                    tempInfo = temp;
                    prev = prev.next;
                }
                prev.setInformation(tempInfo);
            }
            work = work.next;
        }
    }

}
