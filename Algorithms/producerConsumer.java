package Algorithms;

import java.util.LinkedList;

public class producerConsumer {
    public static void main(String[] args) throws InterruptedException{
        // PC class has both produce and consume methods
        final PC pc = new PC();

        // creating producer thread. Threads has inturrepted exception
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // creating consumer thread. Threads has inturrepted exception
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // for calling the run method of thread
        t1.start();
        t2.start();
        
        // join() method allows one Thread to waits until it completes its execution (child Thread terminates and join main thread)
        t1.join();
        t2.join();
    }
}

class PC{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;

        while(true){
            // sync block so that only a producer or a consumer thread runs at a time
            synchronized (this){
                if (list.size() == capacity)
                    wait();

                // If the list is empty, the control passes to below the loop and it adds a value in the list.
                System.out.println("Producer produced - "+value);

                list.add(value++);
                notify();           // notify once you have something in list, you can have the consumer thread consume it.
                Thread.sleep(1000); // just for visualization
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (this){
                
                //If it is empty then we make the consumer thread give up the lock on PC and passes the control to producer thread for producing more jobs
                if (list.size() == 0)
                    wait();

                int val = list.removeFirst();
                System.out.println("Consumer removed - "+val);

                notify();           // if you have consumed something, you can have the producer produce something.
                Thread.sleep(1000); // for visualization
            }
        }
    }
}
