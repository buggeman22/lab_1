import java.util.Comparator;

public class TestPriorityQueue {

    public static void main(String[] args) {
        testPriorityQueue();
    }

    private static void testPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        pq.add(9);
        pq.add(2);
        pq.add(6);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();

        PriorityQueue<String> pq2 = new PriorityQueue<>();
        pq2.add("C");
        pq2.add("C#");
        pq2.add("java");
        pq2.add("C++");

        while (!pq2.isEmpty()) {
            System.out.print(pq2.remove() + " ");
        }
        System.out.println();
    }

}