package com.bernard.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableQueueTest {

    @Test
    public void enQueue() throws Exception {
        Queue<Integer> queue = new ImmutableQueue<Integer>(1);
        queue = queue.enQueue(2);
        assertEquals((int) queue.head(), 1);
    }

    @Test
    public void deQueue() throws Exception {
        Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();
        queue = queue.enQueue(1);
        queue = queue.enQueue(2);
        queue = queue.deQueue();
        assertEquals((int) queue.head(), 2);
    }

    @Test
    public void isEmpty() throws Exception {
        Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();
        queue = queue.enQueue(2);
        queue = queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test(expected = Exception.class)
    public void deQueueShouldThrowException() throws Exception{
        Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();
        queue = queue.enQueue(2);
        queue = queue.deQueue();
        queue.deQueue();
    }

    @Test(expected = Exception.class)
    public void headShouldThrowException() throws Exception{
        Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();
        queue.head();
    }
}