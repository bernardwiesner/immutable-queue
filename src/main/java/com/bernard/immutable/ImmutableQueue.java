package com.bernard.immutable;

public final class ImmutableQueue<T> implements Queue<T>{

    private final T value;
    private final Queue<T> parent;

    ImmutableQueue(T value){
        this.value = value;
        this.parent = new EmptyQueue<T>();
    }

    private ImmutableQueue(T value, Queue<T> parent){
        this.value = value;
        this.parent = parent;
    }

    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(t, this);
    }

    public Queue<T> deQueue() throws Exception{
        Queue<T> reversedQueue = reverseQueue(this);
        return reverseQueue(reversedQueue.getParent());
    }   
    
    private Queue<T> reverseQueue(Queue<T> queue) throws Exception{
        Queue<T> reversedQueue = new EmptyQueue<T>();
        while(!queue.isEmpty()){
            reversedQueue = reversedQueue.enQueue(queue.getValue());
            queue = queue.getParent();
        }     
        return reversedQueue;
    }

    public T head() throws Exception{

        if(getParent().isEmpty()){
            return this.getValue();
        }
        
        Queue<T> queue = this;
        while(!queue.getParent().isEmpty()){
            queue = queue.getParent();
        }
        return queue.getValue();
    }

    public boolean isEmpty() {
        return false;
    }

    public Queue<T> getParent() {
        return this.parent;
    }

    public T getValue() {
        return this.value;
    }

    public static class EmptyQueue<T> implements Queue<T>{

        public Queue<T> enQueue(T t){
            return new ImmutableQueue<T>(t,this);
        }

        public Queue<T> deQueue() throws Exception{
            throw new Exception("Queue is empty. Cannot deQueue.");
        }

        public T head() throws Exception{
            throw new Exception("Queue is empty. Cannot access head.");
        }

        public boolean isEmpty(){
            return true;
        }

        public Queue<T> getParent() throws Exception{
            throw new Exception("Queue is empty, has no parent.");
        }

        public T getValue() throws Exception{
            throw new Exception("Queue is empty, has no value.");
        }
    }
}
