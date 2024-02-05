package JavaFeatures;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import Util.User;


public class Feature8 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // List.of(11, 222, 333);
        // By defualt it uses ForkJoinPool.commonPool() , or we can use Executors.newFixedThreadPool(2) as param to completeFuture
        // Run Async Example : Returns of type of Void

        Runnable r = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        CompletableFuture<Void> cf_run_Async = CompletableFuture.runAsync(r);
        cf_run_Async.get();
        System.out.println("Main Method:After Run Async");

/*
        Runnable Method doesnot  return any value where as callable returns.
 */        
        Callable<Integer> r2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        };

        CompletableFuture<Integer> cf_supply_Async = CompletableFuture.supplyAsync(() -> {
            try {
                return r2.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });




        int result = cf_supply_Async.get();
        System.out.println("Result=" + result);
        System.out.println("Main Method:After Suppply Async");



        cf_supply_Async.thenAccept(num->{
            //It has access to future attached.
            System.out.println("Then Accept:"+num);
        });

       CompletableFuture<Integer> cf_with_then_Apply=cf_supply_Async.thenApply(num->{
            return num*2;
        });

        Integer result2=cf_with_then_Apply.get();
        System.out.println("Result2="+result2);

         cf_run_Async.thenRun(()->{
            //It has no access to future attached.
            System.out.println("Then Run: Has no access to Furure return");
        });
    }


    private static void  comparatorExample(){

     Comparator<User> NameComparator   =Comparator.comparing(User::getFname);

     Comparator<User> UserComparatorChaninng = Comparator.comparing(User::getAge).thenComparing(User::getFname);

     Comparator<User> UserComparator =( a, b)->a.getAge().compareTo(b.getAge());

    }

}


