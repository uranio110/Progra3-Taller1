package co.edu.uptc.model;

import java.util.*;

public class MyList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public MyList() {
        head = null;
        size = 0;
    }

    // ── Agrega al final ──────────────────────────────────────────
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // ── Acceso por índice ────────────────────────────────────────
    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // ── Eliminar por índice ──────────────────────────────────────
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removed;
        if (index == 0) {
            removed = head.value;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removed = current.next.value;
            current.next = current.next.next;
        }
        size--;
        return removed;
    }

    // ── Tamaño───────────────────────────────────────────
    @Override
    public int size() { return size; }

    // ── Set (necesario para Collections.sort) ────────────────────
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T old = current.value;
        current.value = element;
        return old;
    }

    // ── Iterator (necesario para Collections.sort) ───────────────
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() { return current != null; }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    // ── adicionales ───────────────────────────────────────────────────
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // ── Métodos no usados ────────────────────────────────────────
    @Override public boolean isEmpty() { return size == 0; }
    @Override public void add(int index, T element) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(Collection<? extends T> c) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(int index, Collection<? extends T> c) { throw new UnsupportedOperationException(); }
    @Override public void clear() { throw new UnsupportedOperationException(); }
    @Override public boolean contains(Object o) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public int indexOf(Object o) { throw new UnsupportedOperationException(); }
    @Override public int lastIndexOf(Object o) { throw new UnsupportedOperationException(); }
    @Override public ListIterator<T> listIterator() { throw new UnsupportedOperationException(); }
    @Override public ListIterator<T> listIterator(int index) { throw new UnsupportedOperationException(); }
    @Override public boolean remove(Object o) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public List<T> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
    @Override public Object[] toArray() { throw new UnsupportedOperationException(); }
    @Override public <E> E[] toArray(E[] a) { throw new UnsupportedOperationException(); }
}