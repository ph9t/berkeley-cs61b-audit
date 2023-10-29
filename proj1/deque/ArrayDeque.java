package deque;

import java.util.ArrayList;

public class ArrayDeque<T> implements Deque<T> {
    private static final int MIN_SIZE = 8;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.items = (T[]) new Object[MIN_SIZE];
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    @Override
    public void addLast (T item) {
        if (isFull()) resize(this.size * 2);

        this.items[this.nextLast] = item;
        this.size = this.size + 1;
        this.nextLast = getIndex(true, true);
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) resize(this.size * 2);

        this.items[this.nextFirst] = item;
        this.size = this.size + 1;
        this.nextFirst = getIndex(false, true);
    }

    @Override
    public T removeLast() {
        if (this.size == 0) return null;

        int last = getIndex(true, false);
        T removedItem = this.items[last];

        this.items[last] = null;
        this.size = this.size - 1;
        this.nextLast = last;

        if (isTooBig()) resize(this.items.length / 4);

        return removedItem;
    }

    @Override
    public T removeFirst() {
        if (this.size == 0) return null;

        int first = getIndex(false, false);
        T removedItem = this.items[first];
        this.items[first] = null;
        this.size = this.size - 1;
        this.nextFirst = first;

        if (isTooBig()) resize(this.items.length / 4);

        return removedItem;
    }


    private void resize(int capacity) {
        T[] TA = (T[]) new Object[capacity];

        int first = getIndex(false, false);
        for (int x = first; x < this.size + first; x++) {
            int idx = Math.floorMod(x, this.items.length);

            int newIdx = Math.floorMod(x - first, TA.length);
            TA[newIdx] = this.items[idx];
        }

        this.items = TA;
        this.nextFirst = Math.floorMod(this.items.length - 1, TA.length);
        this.nextLast = Math.floorMod(this.size, TA.length);
    }

    private int getIndex(boolean last, boolean next) {
        int pos = this.nextLast;
        int k = 1;

        if (!last) pos = this.nextFirst;
        if (last && !next || !last && next) k = -1;

        return Math.floorMod(pos + k, this.items.length);
    }

    private boolean isFull() { return this.size == this.items.length; }
    private boolean isTooBig() {
        return ((float) this.size / this.items.length < 0.25) && (this.items.length > 16);
    }

    @Override
    public int size(){ return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public void printDeque() {

    }

    @Override
    public T get(int index) {
        if (this.size == 0) return null;
        int first = Math.floorMod(this.nextFirst + 1, this.items.length);
        int idx = Math.floorMod(first + index, this.items.length);
        return this.items[idx];
    }
}