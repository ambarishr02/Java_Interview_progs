package Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	
public static void main(String[] args) {
	ExecutorService service = Executors.newFixedThreadPool(5);
	final CountDownLatch latch = new CountDownLatch(3);
	 
	for(int i = 0; i < 3; i++) {
	    service.submit(new Runnable() {
	        public void run() {
	        	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	System.out.println("=========");
	            latch.countDown();
	        }
	    });
	}
	 
	try {
		latch.await();
		System.out.println("--------");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
