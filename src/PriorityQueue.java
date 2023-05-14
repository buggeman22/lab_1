import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {

    private List<T> heap;
    private Comparator<T> comparator;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void add(T element) {
        heap.add(element);
        siftUp(size() - 1);
    }

    public T remove() {
        T root = heap.get(0);
        int lastIndex = size() - 1;
        T last = heap.remove(lastIndex);
        if (lastIndex > 0) {
            heap.set(0, last);
            siftDown(0);
        }
        return root;
    }

    public T peek() {
        return heap.get(0);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (compare(heap.get(index), heap.get(parentIndex)) <= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int lastIndex = size() - 1;
        while (true) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int maxChildIndex = leftChildIndex;
            if (rightChildIndex <= lastIndex
                    && compare(heap.get(rightChildIndex), heap.get(leftChildIndex)) > 0) {
                maxChildIndex = rightChildIndex;
            }
            if (leftChildIndex > lastIndex || compare(heap.get(maxChildIndex), heap.get(index)) <= 0) {
                break;
            }
            swap(index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int compare(T a, T b) {
        if (comparator == null) {
            return ((Comparable<T>) a).compareTo(b);
        } else {
            return comparator.compare(a, b);
        }
    }

}