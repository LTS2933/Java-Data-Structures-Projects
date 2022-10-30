package arraystackadt;

public interface ArrayStackADT<T> {

    void initializeStack();

    void pop() throws StackUnderflowException;

    T peek() throws StackUnderflowException;
    
    void push(T obj) throws StackOverflowException;
    
    boolean isEmptyStack();

    boolean isFullStack();
    
    String toString();

}
