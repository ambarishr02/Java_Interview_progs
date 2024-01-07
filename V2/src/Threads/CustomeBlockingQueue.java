package Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyBlockingQueue<E> {
	Queue<E> que;
	Lock lock = new ReentrantLock(true);
	Condition empty = lock.newCondition();
	Condition full = lock.newCondition();
	int size = 10;

	MyBlockingQueue(int size) {
		que = new LinkedList<>();
		this.size = size;
	}

	public void put(E value) {
		lock.lock();

		try {
			while (que.size() == size) {
				empty.await();
			}
			que.add(value);
		System.out.println("Added:"+value);
			full.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public E take() {
		lock.lock();

		try {
			while (que.isEmpty()) {
				try {
					full.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			E item = que.remove();
			System.out.println("Removed:"+item);
			empty.signal();
			return item;

		} finally {
			lock.unlock();
		}

	}

}


class ConsumerThead implements Runnable {
    private MyBlockingQueue<Integer>  que;
 
    public ConsumerThead(MyBlockingQueue<Integer> que){
        this.que = que;
    }
    @Override
    public void run() {
    	  while(true) {
    		  que.take();
         
    	  }
        
    }
 
}

class ProducerThread implements Runnable {
	 
	private MyBlockingQueue<Integer>  que;
	 
    public ProducerThread(MyBlockingQueue<Integer> que){
        this.que = que;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            que.put(i);
        }
    }
 
}

public class CustomeBlockingQueue {

	public static void main(String[] args) {

		MyBlockingQueue<Integer> que = new MyBlockingQueue<>(10);
		
		Thread producer = new Thread(new ProducerThread(que),"Producer");
        Thread consumer = new Thread(new ConsumerThead(que),"Consumer"); 
        
        
        producer.start();
        consumer.start();
		

	}

}
