package algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllSubsets {

    static void prinAllSubsets(char[] arr){
        List<String> list=new ArrayList<>();
        list.add("[]");
        subsetUtil(arr, list);
    }

     static void subsetUtil(char arr[], List<String> list){
        List<String> temp;
        for (int i = 0; i < arr.length; i++) {
            temp=new ArrayList<>();
            Iterator<String> itr=list.iterator();
            while(itr.hasNext()){
                String value=itr.next();
                if(value.equals("[]")){
                    temp.add("["+arr[i]+"]");
                }else{
                    temp.add("["+value.substring(1, value.length()-1)+","+arr[i]+"]");
                }

            }
            System.out.println("==="+temp.toString());
            list.addAll(temp);
        }

        System.out.println(list.toString());
     }
    //out put
    // [ [],[a],[b],[c]]


    static void otherApproach(char arr[]){
        int n=arr.length;
        for (int i = 0; i < (1<<n) ; i++) {
            System.out.print("{ ");
            for (int j = 0; j <arr.length; j++) {
                int y= (1<<j);
                int x=(i & y);
                if(x>0){
                    System.out.print(arr[j]+" ");
                }
              
            }
            System.out.println("}");
        }
    }
    
    public static void main(String[] args) {
        char[] arr={'a','b','c'};
     
        prinAllSubsets(arr);
       // otherApproach(arr);
    // System.out.println(1<<0);
    }
}
