package synthesizer;

interface BoundedQueue<T> extends Iterable<T> {
    /* Return size of the buffer*/
    int capacity();

    /* Return number of items currently in the buffer */
    int fillCount();

    /* Add item x to the end */
    void enqueue(T t);

    /* Delete and return item from the front */
    T dequeue();

    /* Return (but do not delete) item from front */
    T peek();

    /* is the buffer empty (fillCount equals to zero) */
    default boolean isEmpty() {
        return false;
    }

    /* is the buffer full (fillCount equals to capacity) */
    default boolean isFull() {
        return false;
    }
}
