package Threads;

public class CreateEx  {

    
    
    public static void main(String[] args) {

    Mythread mythread=new Mythread();
    Thread t1=new Thread(mythread);
    t1.start();
        
    }

   
    
}

class Mythread implements Runnable{

    @Override
    public void run() {
       System.out.println("Mythread running");
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
