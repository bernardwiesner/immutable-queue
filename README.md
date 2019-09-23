# Immutable Queue

An immutable queue does not modify the values of an existing queue, but always recreates the queue and return a new queue.

Check out the Application.java for use cases.

## Instantiate queue

`Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();`

## Add item to the queue

`queue = queue.enQueue(1);`

## Retrieve first item on the queue

`queue.head();` 

## Remove first item from the queue

`queue = queue.deQueue();` 

## Check if queue is empty

`queue.isEmpty()`