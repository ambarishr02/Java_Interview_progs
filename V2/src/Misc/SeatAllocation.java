package Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SeatAllocation {
    
    public static void main(String[] args) {
        int arr[][]={{1,2},
                     {1,3},
                     {1,8},
                     {2,6},
                     {3,1},
                     {3,10}};
        int n=3;

        maxNumberOfFamilies(arr,n);
    }

    private static void maxNumberOfFamilies(int arr[][], int n) {
         Boolean seatBlock[]=null;
        Map<Integer, Boolean[]> seatMap=new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int row=arr[i][0]; //row
            int seatNo=arr[i][1]; //seat number
            if(seatNo==1 || seatNo==10){
                continue;
            }
            if(seatMap.containsKey(row)){
                seatBlock=seatMap.get(row);
            }else{
                seatBlock=new Boolean[3];
                seatBlock[0]=true;
                seatBlock[1]=true;
                seatBlock[2]=true;
            }
            if(seatNo==2 || seatNo==3) 
              seatBlock[0]=false;
            else if(seatNo==8 ||seatNo==9)  
                seatBlock[2]=false;
            else if(seatNo==4 || seatNo==5){
                seatBlock[1]=false;   
                seatBlock[0]=false;
             }
           else if(seatNo==6 || seatNo==7){
                seatBlock[1]=false;
                seatBlock[2]=false;
            }
            seatMap.put(row, seatBlock);
        }
        int count=0;
        for(Entry<Integer, Boolean[]> e: seatMap.entrySet()){
            seatBlock=e.getValue();
            if(seatBlock[0] && seatBlock[1]&& seatBlock[2]){
                count=count+2;
            } 
            if(seatBlock[1] || seatBlock[0] || seatBlock[2]){
                count=count+1;
            }
            if(seatBlock[0] && seatBlock[1]){
                count=count+1;
            } if(seatBlock[1] && seatBlock[2]){
                count+=1;
            }

        }
        count=count+((n-seatMap.size())*2);
        System.out.println(count);

    }
}


