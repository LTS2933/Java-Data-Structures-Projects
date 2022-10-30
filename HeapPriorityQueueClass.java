package heappriorityqueue;

public class HeapPriorityQueueClass <T> implements HeapPriorityQueue<T> {

    private int size;
    private int maxSize;
    private int queueFront;
    private int queueRear;
    private T[] elements;

    public HeapPriorityQueueClass() {
        maxSize = 250;
        size = 0;
        queueFront = 0;
        queueRear = maxSize - 1;
        elements = (T[]) new Object[maxSize];
    }
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return (size == (maxSize - 1));
    }
    @Override
    public void enqueue(T addOn) throws HeapOverflowException {
        if (isFull()) {
            throw new HeapOverflowException();
        }
        queueRear = ((queueRear + 1) % maxSize);
        size++;
        elements[queueRear] = addOn;
        reheapifyUpward(queueRear);
    }
    @Override
    public void dequeue() throws HeapUnderflowException {
        if (isEmpty()) {
            throw new HeapUnderflowException();
        }
        size--;
        elements[queueFront] = elements[queueRear];
        elements[queueRear] = null;
        queueRear = ((queueRear - 1) % maxSize);
        reheapifyDownward(queueFront);
    }
    @Override
    public void reheapifyUpward(int spot) {
        if ((Integer) elements[spot] > (Integer) elements[(spot - 1) / 2]) {
            T newObj = elements[(spot - 1) / 2];
            elements[(spot - 1) / 2] = elements[spot];
            elements[spot] = newObj;
            reheapifyUpward((spot - 1) / 2);
        }
    }
    @Override
    public void reheapifyDownward(int spot) {
        if (elements[2 * spot + 1] != null && elements[2 *spot + 2] != null) {
            T Obj = elements[2 * spot + 1];
            T newObj = elements[2*spot + 2];

            if ((Integer) Obj > (Integer) newObj) {
                elements[2 * spot + 1] = elements[spot];
                elements[spot] = Obj;
                reheapifyDownward(2 * spot + 1);
            } else {
                elements[2 * spot + 2] = elements[spot];
                elements[spot] = newObj;
                reheapifyDownward(2 * spot + 2);
            }
        } else if (elements[2 * spot + 1] != null && elements[2 * spot + 2] == null) {
            T temp = elements[2 * spot + 1];

            if ((Integer) temp > (Integer) elements[spot]) {
                elements[2 * spot + 1] = elements[spot];
                elements[spot] = temp;
            }
        } else if (elements[2 * spot + 1] == null && elements[2 * spot + 2] != null) {
            T temp = elements[2 * spot + 2];

            if ((Integer) temp > (Integer) elements[spot]) {
                elements[2 * spot + 2] = elements[spot];
                elements[spot] = temp;
            }
        }
    }
    @Override
    public void reposition(int newSpot) throws HeapUnderflowException {
        if (isEmpty())
            throw new HeapUnderflowException();
        if (newSpot > maxSize - 1) {
            System.out.println("Must choose a valid index.");
            return;
        }
        elements[newSpot] = elements[queueRear]; 
    }
    public String inOrder() {
        String str = "";
        str += "Here is an inOrder traversal of the heap: " + inOrder(0) + "\n";
        return str;
    }
    public String inOrder(int spot){
        String str = "";
        if(elements[spot]!=null) {
                        str += inOrder(2*spot+1);
                        str += elements[spot] + " ";
                        str += inOrder(2*spot+2);
                }
                return str; 
    }
    public String toString(){
       String str = "To show what the heap of size " + getSize() + " looks like,\n";
       str += "Let's do an inOrder traversal.\n";
       str += inOrder();
       return str;
    }
}
