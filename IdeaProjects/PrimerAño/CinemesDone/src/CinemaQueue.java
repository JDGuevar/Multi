public class CinemaQueue {
    Information first;
    Information last;

    int assistance;

    boolean full = false;

    int totalAdults = 0;
    int totalChildren = 0;
    int totalTeen = 0;

    public CinemaQueue(int assistance) {
        first = null;
        last = null;
        this.assistance = assistance;
    }
    public void insert(Information work) {
        if (full) {
            System.out.println("The queue is full");
        }
        int total = totalAdults + totalChildren + totalTeen;
        int group = work.adults + work.children + work.teen;
        if (total + group > assistance){
            full = true;
            return;
        }

        if (first == null){
            first = work;
        }else {
            last.next = work;
        }
        last = work;
        totalAdults += work.adults;
        totalChildren += work.children;
        totalTeen += work.teen;
    }
}
