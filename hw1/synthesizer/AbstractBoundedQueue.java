package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return 0;
    }

    public int fillCount() {
        return 0;
    }

    public abstract void enqueue(T t);

    public abstract T dequeue();

    public abstract T peek();

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }
}
