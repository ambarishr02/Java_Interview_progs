package Threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExeSer {
    

    public static void main(String[] args) {
      
       ExecutorService service=Executors.newFixedThreadPool(3);

       Future<Integer> f=service.submit(new Task());
       
       try {
        System.out.println(f.get());
    } catch (InterruptedException | ExecutionException e) {
      
    }


      
    }


    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return new Integer(new Random().nextInt(5));
        }
        
    }
}
