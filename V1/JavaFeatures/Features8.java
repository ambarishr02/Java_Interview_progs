package JavaFeatures;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class Features8 {
    public static void main(String[] args) {
        
        UnaryOperator<Integer> unaryOperator=(x) ->2*x;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate=(n, str)-> {
            return n>10 && str.length()>5;
        };
        System.out.println(biPredicate.test(11,"CheckBiPredicate"));
       
         BiFunction<Integer, String, String> biFunction=(n, str)-> {
            return n+","+str.length();
        };

        System.out.println(biFunction.apply(10,"bifunctio"));

        BiConsumer<String,String> biConsumer=(s1,s2)->{
            System.out.println(s1+","+s2);
        };

        biConsumer.accept("Test1","Test2");

    }
}
