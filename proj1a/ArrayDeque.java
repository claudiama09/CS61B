public class ArrayDeque<T> {
    private int size = 0;
    private int nextFirst;
    private int nextLast;
    private int item = 0;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = item + 1;
        nextLast = item + 2;
    }

    public void addFirst(T x) {
        if (size == items.length - 2) {
            resizeWithIncrease();
        }

        items[nextFirst] = x;

        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }

        size += 1;
    }

    public void addLast(T x) {
        if (size == items.length - 2) {
            resizeWithIncrease();
        }

        items[nextLast] = x;

        if (nextLast == items.length) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }

        size += 1;
    }

    private void resizeWithIncrease() {
        T[] newItems = (T[]) new Object[items.length * 2];
        boolean flag = true;
        int index = 0;

        while (flag) {
            if (nextFirst != nextLast) {
                if (nextFirst == items.length - 1) {
                    nextFirst = 0;
                } else {
                    nextFirst += 1;
                }
                if (items[nextFirst] != null) {
                    index += 1;
                    newItems[index] = items[nextFirst];
                }
            } else {
                flag = false;
            }
        }

        nextFirst = 0;
        nextLast = index + 1;
        items = newItems;

    }

    public void resizeWithDecrease() {
        if (items.length < 16) {
            return;
        }
        if (size * 2 > items.length) {
            return;
        }

        int newLength = Double.valueOf(items.length * 0.75).intValue();
        T[] newItems = (T[]) new Object[newLength];
        boolean flag = true;
        int index = 0;

        while (flag) {
            if (nextFirst != nextLast) {
                if (nextFirst == items.length - 1) {
                    nextFirst = 0;
                } else {
                    nextFirst += 1;
                }
                if (items[nextFirst] != null) {
                    index += 1;
                    newItems[index] = items[nextFirst];
                }
            } else {
                flag = false;
            }
        }

        nextFirst = 0;
        nextLast = index + 1;
        items = newItems;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return items[index - 1];
    }

    public void printDeque() {

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }

        T t = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        resizeWithDecrease();

        return t;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast -= 1;
        }

        T t = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        resizeWithDecrease();

        return t;
    }
}
