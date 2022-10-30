package arraystackadt;

public class ArrayStackDataStrucClass<T> implements ArrayStackADT<T> {

    private T[] objArray;
    private int stackMaxSize;
    private int stackTop;

    public ArrayStackDataStrucClass() {
        stackMaxSize = 100;
        stackTop = 0;
        objArray = (T[]) new Object[stackMaxSize];
    }

    public ArrayStackDataStrucClass(int stackSize) {
        if (stackSize <= 0) {
            System.err.println("The size of the array to implement must bde positive."); //from lecture doc on queues
            System.err.println("Creating an array of the size 100.");
            stackMaxSize = 100;
        } else {
            stackMaxSize = stackSize;
        }
        stackTop = 0;

        objArray = (T[]) new Object[stackMaxSize];
    }

    @Override
    public void initializeStack() {
        for (int i = 0; i < stackTop; i++) {
            objArray[i] = null;
        }
        stackTop = 0;
    }

    @Override
    public boolean isEmptyStack() {
        if (stackTop == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFullStack() {
        return (stackTop == stackMaxSize);
    }
    @Override
    public String toString() { //so that the output will print all the factors rather than the memory address
        String str = "";
        while (!isEmptyStack()) {
            str += peek();
            pop();
            if (!isEmptyStack()){
            str += " * ";
        }
        }
        return str;
    }
@Override
    public void pop() throws StackUnderflowException {
        if (isEmptyStack() == true) {
            throw new StackUnderflowException();
        }
        stackTop-=1;
        objArray[stackTop] = null;
    }
    @Override
    public void push(T obj) throws StackOverflowException {
        if (isFullStack()) {
            throw new StackOverflowException();
        }
        objArray[stackTop] = obj;
        stackTop++;
    }
    @Override
    public T peek() throws StackUnderflowException {
        if (isEmptyStack() == true) {
            throw new StackUnderflowException();
        }
        return (T) objArray[stackTop - 1];
    } 
}


