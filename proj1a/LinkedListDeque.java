/* Double-Ended Queue*/
public class LinkedListDeque<T> {
    private class Node {

        private Node prev;
        private Node next;
        private T value;
        private String v;

        public Node() {

        }

        private Node(T value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Node sentinel;


    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.v = "sentinel";
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T value) {
        Node itemNode = new Node(value);
        Node p = sentinel;

        if (p.next != p) {
            p.next = itemNode;
            itemNode.prev = p;
            p.prev = itemNode;
        }

        p.next = itemNode;
        p.prev = itemNode;
        itemNode.prev = p;
        itemNode.next = p;
        size += 1;

    }

    public void addLast(T value) {
        Node itemNode = new Node(value);
        Node p = sentinel;

        if (p.next == p) {
            p.next = itemNode;
            p.next.prev = p;
        }

        itemNode.prev = p.prev;
        itemNode.next = p;
        p.prev = itemNode;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
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
        Node p = sentinel;
        Node firstNode = p.next;
        p.next = firstNode.next;
        firstNode.next.prev = p;

        size -= 1;

        return (T) firstNode;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinel;
        Node lastNode = p.prev;
        p.prev = lastNode.prev;
        lastNode.prev.next = p;

        size -= 1;

        return (T) lastNode;
    }

    public Node get(int index) {
        Node p = sentinel;
        int i = 0;
        if (index > size) {
            return null;
        }
        while (i < index) {
            p = p.next;
            i += 1;
        }
        return p;
    }

    public Node getRecursive(int index) {
        Node p = sentinel;
        if (index < 0 || index > size - 1) {
            return null;
        }

        return recursive(p, index);

    }

    private Node recursive(Node n, int index) {
        if (index < 0) {
            return n;
        }
        return recursive(n.next, index - 1);
    }
}
