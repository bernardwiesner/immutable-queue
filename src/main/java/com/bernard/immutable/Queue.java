package com.bernard.immutable;
public interface Queue<T> {
    Queue<T> enQueue(T t);
    // Removes the element at the beginning of the immutable queue, and returns the new queue.
    Queue<T> deQueue() throws Exception;
    T head() throws Exception;
    boolean isEmpty();

    Queue<T> getParent() throws Exception;
    T getValue() throws Exception;
}