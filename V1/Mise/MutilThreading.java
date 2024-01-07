
import java.util.ArrayList;
import java.util.List;

class Producer {
	private List<Integer> data = new ArrayList<Integer>();

	private static final int MIN = 0;
	private static final int MAX = 5;

	Object lock = new Object();
	Integer value = 0;

	public void producer() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (data.size() == MAX) {
					System.out.println("Producer waitig....");
					lock.wait();
					
				} else {
					data.add(value);
					System.out.println("Producer added...."+value);
					value++;
					lock.notifyAll();
				}
				Thread.sleep(500);
			}
		}

	}

	public void consumer() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (data.size() == MIN) {
					lock.wait();
					System.out.println("Consumer waiting....");
				} else {
					System.out.println("Consumer removed...."+data.remove(data.size()-1));
					value--;
					lock.notifyAll();
				}
				Thread.sleep(500);
			}

		}
	}
}

public class MutilThreading {

	public static void main(String args[]) {
		Producer pr = new Producer();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pr.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pr.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		t1.start();
		t2.start();

	}
}
