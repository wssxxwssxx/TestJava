package com.company;

public class Array<E> implements Collection<E> {
    Object[] values;
    int size;
    int capacity;

    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_SIZE     = 0;
    private static final int INCREASE_SIZE    = 8;

    public Array() {
        values     = new Object[INITIAL_CAPACITY];
        size       = INITIAL_SIZE;
        capacity   = INITIAL_CAPACITY;
    }

    public Array(int capacity) {
        values        = new Object[capacity];
        size          = INITIAL_SIZE;
        this.capacity = capacity;
    }

    @Override
    public void insert(E newValue) {
        if (size < capacity) {
            values[size] = newValue;
            size++;
        } else {
            capacity    += INCREASE_SIZE;
            Object[] tmp = new Object[capacity];

            // Copy elements to a new array
            for (int i = 0; i < size; ++i) {
                tmp[i] = values[i];
            }
            // Add new element
            tmp[size] = newValue;
            values    = tmp;
            size++;
        }
    }

    public void insert(E newValue, int index) {
        if (size >= capacity) {
            capacity    += INCREASE_SIZE;
            Object[] tmp = new Object[capacity];
            for (int i = 0; i < size; ++i) {
                tmp[i] = values[i];
            }
            values = tmp;
        }

        if (index < capacity) {
            for (int i = capacity - 1; i > index; --i) {
                values[i] = values[i-1];
            }
            values[index] = newValue;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    public void set(E value, int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        values[index] = value;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
