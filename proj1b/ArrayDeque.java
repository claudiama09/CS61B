public class ArrayDeque<Item> implements Deque<Item> {
    private int size = 0;
    private int nextFirst;
    private int item = 0;
    private int nextLast;
    private Item[] items;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = item + 1;
        nextLast = item + 2;
    }

    public void resizeWithIncrease() {
        Item[] newItems = (Item[]) new Object[items.length * 2];
        boolean flag = true;
        int index = 0;

        while (flag) {
            /* nextFirst servers as a pointer,
            will stop until it reaches the end of the array
            */
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

        int length = Double.valueOf(items.length * 0.75).intValue();
        Item[] newItems = (Item[]) new Object[length];
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

    public void addFirst(Item item) {
        if (size == items.length - 2) {
            resizeWithIncrease();
        }
        items[nextFirst] = item;
        size += 1;

        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(Item item) {
        if (size == items.length - 2) {
            resizeWithIncrease();
        }
        items[nextLast] = item;
        size += 1;

        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        boolean flag = true;
        int first = nextFirst + 1;
        int last = nextLast;

        while (flag) {
            System.out.print(items[first]);
            first += 1;

            if (first == items.length - 1) {
                first = 0;
            }

            if (nextFirst == nextLast) {
                flag = false;
            }
        }
        System.out.println();
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }

        Item first = items[nextFirst];
        size -= 1;
        resizeWithDecrease();
        return first;

    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast -= 1;
        }

        Item last = items[nextLast];
        size -= 1;
        resizeWithDecrease();
        return last;
    }

    public Item get(int index) {
        if (isEmpty()) {
            return null;
        }

        int n = nextFirst + 1 + index;

        if (items.length - 1 > n) {
            return items[n];
        } else {
            return items[n - items.length];
        }
    }
}
