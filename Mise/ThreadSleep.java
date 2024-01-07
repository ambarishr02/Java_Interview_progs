import java.util.concurrent.TimeUnit;

public class ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
    //    Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
        
    }

}