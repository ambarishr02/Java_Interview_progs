package Threads;

public class TheadOne {

	
	public static void main(String[] args) {
		
		Object o1=new Object();
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Err");
			}
			}
		);
		
		
		t1.start();
		
		synchronized (o1) {
			
		}
		
	  Thread t2= new Thread(
			  ()->{
		 
				System.out.println("Err1");
			}
			  );
	  
	   t2.start();
	   try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
