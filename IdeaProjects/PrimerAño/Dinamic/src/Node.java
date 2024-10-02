public class Node {
    private String information;
    Node next;

    public Node(String information){
        this.information = information;
        this.next = null;
    }

    public String getInformation() {
        return information;
    }

    public Node getNext() {
        return next;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
