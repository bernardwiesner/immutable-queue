package com.bernard.immutable;

public class Application {
    
    public static void main(String[] args) throws Exception{
        
        Queue<Integer> queue = new ImmutableQueue.EmptyQueue<Integer>();
        queue = queue.enQueue(1);
        queue = queue.enQueue(null);
        queue = queue.enQueue(3);
        printQueue(queue);
        
        queue = queue.deQueue();
        queue = queue.deQueue();
        queue = queue.deQueue();

        printQueue(queue);
        
    }
    
    private static void printQueue(Queue<Integer> queue) throws Exception{
 
        if(queue.isEmpty()){
             System.out.print("Empty queue");
        }
        while(!queue.isEmpty()){
            System.out.print(queue.head() + " => ");
            queue = queue.deQueue();
        }  
        System.out.println();
        
    }
    
    
}
