package DesignPattern;
/**
 * Logger Impl using the chain of responsibilty.
 *  In Chain of Responsibilty controll flows to next class in the chain only when the previous class is unable to solve the problem.
 * 
 */
abstract class Logger{
static int INFO=1;
static int ERROR=3;
static int DEBUG=2;

Logger nextLevelLogger=null;


    public Logger(Logger nextLogger) {
        this.nextLevelLogger=nextLogger;
    }
    
    public void log(int loglevel, String msg){
        if(nextLevelLogger!=null){
           nextLevelLogger.log(loglevel, msg); 
        }
    }

}


class Info extends Logger{

    public Info(Logger nextLogger) {
        super(nextLogger);
    }
   
    public void log(int loglevel,String msg){
        if(loglevel==Logger.INFO){
            System.out.println("INFO:"+msg);
        }else{
            super.log(loglevel, msg);
        }
    }

}

class Debug extends Logger{

    public Debug(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int loglevel,String msg){
        if(loglevel==Logger.DEBUG){
            System.out.println("Debug:"+msg);
        }else{
            super.log(loglevel, msg);
        }
    }

}

public class ChainofResPattern {

    public static void main(String[] args) {
        Logger logger=new Info(new Debug(null));

        logger.log(Logger.INFO, "info message");
        logger.log(Logger.DEBUG, "debug message");
    }
    
}
