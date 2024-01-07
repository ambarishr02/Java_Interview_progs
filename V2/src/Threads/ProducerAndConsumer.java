package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{
	
	BlockingQueue<Integer> queue;
	

	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		for (int i = 1; i <=50; i++) {
			   System.out.println("Produced item "+i);
			   try {
			    queue.put(i);
			   } catch (InterruptedException e) {
			 
			    e.printStackTrace();
			   }
			  }
		
	}
	
}

class Consumer implements Runnable{
	
	BlockingQueue<Integer> queue;
	

	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}


public class ProducerAndConsumer {
	
	public static void main(String[] args) {
		
		BlockingQueue<Integer> q=new  ArrayBlockingQueue<Integer>(9);
		
		Producer producer=new Producer(q);
		Consumer consumer=new Consumer(q);
		
		new Thread(producer).start();
		new Thread(consumer).start();
//		Thread th1=new Thread(()->{
//			
//		});
		
	}
	
	

}
