package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private Node prev;
        private Node next;
        private T item;

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node p, Node n) {
            this.item = item;
            this.prev = p;
            this.next = n;
        }
    }

    private int size;
    private Node sentinel;


    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel.prev = sentinel;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(null);
        Node itemNode = new Node(item, sentinel, sentinel);
        sentinel.next = sentinel.prev = itemNode;

        this.size += 1;
    }

    /** Add an item in the front of the deque. */
    @Override
    public void addFirst(T item) {
        Node itemNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = itemNode;
        sentinel.next = itemNode;

        this.size += 1;
    }

    /** Add an item in the back of the deque. */
    @Override
    public void addLast(T item) {
        Node itemNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = itemNode;
        sentinel.prev = itemNode;

        this.size += 1;
    }

    /** Remove and return the first item of the deque. */
    @Override
    public T removeFirst() {
        if (this.size == 0) return null;

        Node firstNode = sentinel.next;
        Node nextNode = firstNode.next;
        nextNode.prev = sentinel;
        sentinel.next = nextNode;

        this.size -= 1;
        return firstNode.item;
    }

    /** Remove and return the last item of the deque. */
    @Override
    public T removeLast() {
        if (this.size == 0) return null;

        Node lastNode = sentinel.prev;
        Node prevNode = lastNode.prev;
        prevNode.next = sentinel;
        sentinel.prev = prevNode;

        this.size -= 1;
        return lastNode.item;
    }

    /** Print each element of Deque in one line. */
    @Override
    public void printDeque() {
        Node p = this.sentinel.next;

        while (p != this.sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }

        System.out.println();
    }


    /** Iteratively get ith element by index. */
    @Override
    public T get(int index) {
        if (index > this.size - 1) return null;

        Node p = sentinel.next;

        while (index != 0) {
            p = p.next;
            index = index - 1;
        }

        return p.item;
    }

    /** Recursively get ith element by index */
    public T getRecursive(int index){
        if (index > this.size - 1) return null;
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node p){
        if (index == 0) return p.item;

        return getRecursive(index - 1, p.next);
    }

    /** Returns Deque size. */
    @Override
    public int size() { return this.size; }

    /** Returns true if Deque size equals 0. */
    @Override
    public boolean isEmpty() { return this.size == 0; }
}
