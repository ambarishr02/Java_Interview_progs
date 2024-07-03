package Threads;


class PrintNumber implements Runnable {
	
	public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();
 
    PrintNumber(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
    	//System.out.println(Thread.currentThread().getName()+"_"+number);
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
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

public class PrintNumbers {
	
	
	
	public static void main(String[] args) {
		
		PrintNumber run1=new PrintNumber(0);
		PrintNumber run2=new PrintNumber(1);
		PrintNumber run3=new PrintNumber(2);
		
		Thread th1=new Thread(run1,"TH1");
		Thread th2=new Thread(run2,"TH2");
		Thread th3=new Thread(run3,"TH3");
		
		th1.start();
		th2.start();
		th3.start();
	}

}
