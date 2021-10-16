public class LinkedListDeque<Item> implements Deque<Item> {
    private Node sentinel;
    private int size = 0;

    private class Node {
        private int size = 0;
        private Item value;
        private String v;
        private Node prev;
        private Node next;

        private Node(Item value) {
            this.value = value;
        }

        public Node() {

        }
    }

    public LinkedListDeque() {
        this.sentinel = new Node();
        sentinel.v = "sentinel";
    }

    @Override
    public void addFirst(Item item) {
        Node next = sentinel.next;
        Node newNode = new Node(item);

        if (next != null) {
            next.prev = newNode;
        }

        sentinel.next = newNode;
        newNode.prev = sentinel;
        newNode.next = next;
        size += 1;

    }

    @Override
    public void addLast(Item item) {
        Node next = sentinel;
        Node newNode = new Node(item);
        int index = size;

        while (index > 0) {
            next = next.next;
            index -= 1;
        }

        next.next = newNode;
        newNode.prev = next;
        newNode.next = sentinel;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public Item removeFirst() {
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

    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node lastNode = sentinel.next;
        int index = size;

        while (index > 0) {
            lastNode = lastNode.next;
            index -= 1;
        }

        Node lastSecondNode = lastNode.prev;
        lastSecondNode.next = sentinel;
        lastNode.next = null;
        lastNode.prev = null;
        size -= 1;
        return lastNode.value;

    }

    @Override
    public Item get(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        Node p = sentinel.next;

        while (index > 0) {
            p = p.next;
            index -= 1;
        }

        return p.value;
    }

    public Item getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        Node n = recursiveHelper(index, sentinel);
        return n.value;
    }

    private Node recursiveHelper(int index, Node n) {
        if (index < 0) {
            return null;
        }

        return recursiveHelper(index - 1, n.next);

    }


}
