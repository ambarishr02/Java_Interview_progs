package Threads;

import java.util.concurrent.CompletableFuture;

public class CompFut {

    static CompletableFuture<Void> f=CompletableFuture.runAsync(()->{
        try{
            Thread.sleep(5000);
            System.out.print("In ruAsync");
        }catch(InterruptedException e){

        }
    });


    public static void main(String[] args) {
        try{
        System.out.println("Main...");
        f.get();
            System.out.println("Ma2");
        }catch(Exception e){

        }
    }
    
}
