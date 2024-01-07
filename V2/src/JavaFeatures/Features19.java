package JavaFeatures;

public class Features19 {
    
    public static void main(String[] args) throws InterruptedException {
        
        new Thread(()->{
            for (int i = 10; i < 20; i++) {
                System.out.println(i);
            }
        }).start();
      
      
      
        //Virtual Threads 
        Runnable t= () -> {
            for (int i = 0; i < 10; i++) {
             System.out.println(i);
            }       
        };

       Thread t2= Thread.startVirtualThread(t);
       t2.join();
        System.out.println("Features 19");
    }
}
