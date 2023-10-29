package deque;

public interface Deque<T> {
    public void addFirst(T item);

    public void addLast(T item);

    public T removeFirst();

    public T removeLast();

    public int size();

    public boolean isEmpty();

    public T get(int index);

    public void printDeque();
}
