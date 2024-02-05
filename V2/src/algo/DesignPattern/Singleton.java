package algo.DesignPattern;
public class Singleton{
    private static Singleton _instance=null;
    private Singleton(){}
    public static Singleton getInstance(){ 

        if(_instance ==null){
            _instance=new Singleton();
        }
        return  _instance;
    }

 }

class DoubleCheckSingleton{

    private static DoubleCheckSingleton  _instance=null;

    public  static DoubleCheckSingleton getInstance(){
        if(_instance ==null){
            synchronized(DoubleCheckSingleton.class){
                if(_instance ==null){
                    _instance=new DoubleCheckSingleton();
                }
            }
        }
        return _instance;
    }
 }