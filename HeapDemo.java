package heappriorityqueue;
public class HeapDemo {
    public static void main(String [] args){
        HeapPriorityQueueClass myHeap = new HeapPriorityQueueClass();
                myHeap.enqueue(1);
                myHeap.enqueue(2);
                myHeap.enqueue(3);
                myHeap.enqueue(4);
                myHeap.enqueue(5);
                myHeap.enqueue(6);
                myHeap.enqueue(7);
                myHeap.enqueue(8);
                myHeap.enqueue(9);
                myHeap.enqueue(10);
                System.out.println("Here is myHeap with 10 priority values\n" + myHeap);
                myHeap.dequeue();
                System.out.println("One value removed from myHeap \n" + myHeap);
                myHeap.dequeue();
                System.out.println("Second value removed from myHeap \n" +myHeap);
                myHeap.dequeue();
                System.out.println("Third value removed from myHeap \n" +myHeap);
    }
}
