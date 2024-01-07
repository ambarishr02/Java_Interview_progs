package ThreadsExamples;

class PrintOddEvenRunnnable implements Runnable {

	int MAX_NUMBER = 10;
	int rem;
	static int number = 1;
	static Object lock = new Object();

	PrintOddEvenRunnnable(int rem) {
		this.rem = rem;
	}

	@Override
	public void run() {
		while (number < MAX_NUMBER) {
			synchronized (lock) {
				while(number % 2 != rem) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}

		}

	}
}

public class PrintOddEven {

	public static void main(String[] args) {
		PrintOddEvenRunnnable oddRunnable = new PrintOddEvenRunnnable(1);
		PrintOddEvenRunnnable evenRunnable = new PrintOddEvenRunnnable(0);

		Thread thread1 = new Thread(oddRunnable, "Mythread-1");
		Thread thread2 = new Thread(evenRunnable, "Mythread-2");

		thread1.start();
		thread2.start();
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
