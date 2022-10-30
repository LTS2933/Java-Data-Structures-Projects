package heappriorityqueue;
public interface HeapPriorityQueue<T> {
    boolean isEmpty();
    boolean isFull();
    void enqueue(T addOn);
    void dequeue();
    void reheapifyUpward(int spot);
    void reheapifyDownward(int spot);
    void reposition(int newSpot);
}
