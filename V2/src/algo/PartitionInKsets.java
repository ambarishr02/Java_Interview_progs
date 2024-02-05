package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Partition input with k subsets 
 * Input value=3   k=2
 * [1,2][3]
 * [1,3][2]
 * [1][2,3]
 */

public class PartitionInKsets {

    public static void solution(int n, int k, List<List<Integer>> result, int i, int listCount){

        if(i>n){
            if(listCount==k){
                for(List<Integer> set:result){
                    System.out.print(set.toString());
                }
                System.out.println();
            }
            return;
        }
        

        for (int j = 0; j < result.size(); j++) {
            if(result.get(j).size()>0){
                result.get(j).add(i);
                 solution(n,k,result, i+1,listCount);
                result.get(j).remove(result.get(j).size()-1);
            }else{
                result.get(j).add(i);
                solution(n, k , result, i+1,listCount+1);
                result.get(j).remove(result.get(j).size()-1);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
    //    Scanner sc= new Scanner(System.in);
    //    int n =3;
    //    int k=2;

    //    List<List<Integer>> result=new ArrayList<>();
    //    for (int i = 0; i < k; i++) {
    //     result.add(new ArrayList<>());
    //    }
    //     solution(n, k,result,1,0);

       int arr[]={1,2 , 3,4, 5, 6};
       int k=3;
       int subsetSum[]=new int[k];

       List<List<Integer>> result1=new ArrayList<>();
       for (int i = 0; i < k; i++) {
         result1.add(new ArrayList<>());
       }
       partittionWithEqualSum(arr, subsetSum, 0, result1,arr.length,k,0,"");
    }

    static void validateData(int arr[], int k){
        if(k> arr.length ) return;
        int sum= Arrays.stream(arr).sum();
        if(sum %k != 0)  return ;
        
    }

    static void partittionWithEqualSum(int arr[], int subsetSum[], int listCount, List<List<Integer>> result, int n,  int k, int valIdx,String str){
        if(valIdx==arr.length){
            if(listCount==k){
                    boolean flag=true;
                   for (int i = 0; i < subsetSum.length-1; i++) {
                     if(subsetSum[i]!= subsetSum[i+1]){
                        flag=false;
                        break;
                     }
                   } 
                 if(flag) { 
                System.out.println("=====");
                for(List<Integer> t:result){
                    System.out.println(t.toString());
                }
                System.out.println();
            }
            }
            return;
        }

     for (int i = 0; i < result.size(); i++) {
        if(result.get(i).size()>0){
            result.get(i).add(arr[valIdx]);
            subsetSum[i] +=arr[valIdx];
            partittionWithEqualSum(arr, subsetSum, listCount, result,n,k, valIdx+1,"if"); 
             subsetSum[i] -=arr[valIdx];
            result.get(i).remove( result.get(i).size()-1);
        }else{
             result.get(i).add(arr[valIdx]);
            subsetSum[i] +=arr[valIdx];
            partittionWithEqualSum(arr, subsetSum,listCount+1, result,n,k, valIdx+1,"else");
            subsetSum[i] -=arr[valIdx];
            result.get(i).remove( result.get(i).size()-1);
            break;
        }
     }   

    }
}




// k subsets  -> k list -> each list be a list of numbers 