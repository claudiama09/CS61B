/* Double-Ended Queue*/
@SuppressWarnings("unchecked")
public class LinkedListDeque<T> {
    private class Node {

        private Node prev;
        private Node next;
        private T value;
        private String v;

        private Node() {

        }

        private Node(T value) {
            this.value = value;
        }
    }

    private int size = 0;
    private final Node sentinel;


    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.v = "sentinel";
    }

    public void addFirst(T value) {
        Node itemNode = new Node(value);
        Node next = sentinel.next;

        if (next != null) {
            next.prev = itemNode;
        }

        sentinel.next = itemNode;
        itemNode.prev = sentinel;
        itemNode.next = next;
        size += 1;
    }

    public void addLast(T value) {
        Node itemNode = new Node(value);
        Node lastNode = sentinel;
        int index = size;

        while (index > 0) {
            lastNode = lastNode.next;
            index -= 1;
        }

        lastNode.next = itemNode;
        itemNode.prev = lastNode;
        itemNode.next = sentinel;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        T[] queue = null;
        int i = 0;
        while (i < size) {
            System.out.print(p.next.value);
            p = p.next;
            i += 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node firstNode = sentinel.next;

        if (firstNode.next != null) {
            Node secondNode = firstNode.next;
            sentinel.next = secondNode;
            secondNode.prev = sentinel;
        } else {
            sentinel.next = null;
        }

        size -= 1;

        return firstNode.value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node lastNode = sentinel.next;
        int index = size;

        while (index > 0) {
            lastNode = lastNode.next;
            index -= 1;
        }

        Node secondLastNode = lastNode.prev;
        secondLastNode.prev = sentinel;
        lastNode.next = null;
        lastNode.prev = null;

        size -= 1;

        return lastNode.value;
    }

    public T get(int index) {
        Node p = sentinel.next;

        if (index > size) {
            return null;
        }
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.value;
    }

    public T getRecursive(int index) {
        Node p = sentinel;
        if (index < 0 || index > size - 1) {
            return null;
        }

        return recursive(p, index);

    }

    private T recursive(Node n, int index) {
        if (index < 0) {
            return n.value;
        }
        return recursive(n.next, index - 1);
    }
}
