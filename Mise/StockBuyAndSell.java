import java.util.ArrayList;
import java.util.List;

class Interval{
	int buy;
	int sel;
}


public class StockBuyAndSell {
	
	
	//find local maxima and minima
	 static void getProfict(int arr[]){
	  
		int n,i;
		int minima;
		int maxima;
		List<Interval> list=new ArrayList<>();
		
		n=arr.length;
		i=0;
		while(i<n) {
			
			while(i<n-1 && arr[i] <=arr[i+1])
				i++;
			
		    if(i==n-1) {
		    	break ;
		    }
			minima=i-1;
			
		   while(i<n && arr[i]>=arr[i-1]) {
			   i++;
		   }
		   
		   maxima =i-1;
		   Interval e =new Interval();
		   e.buy=minima;
		   e.sel=maxima;
		   list.add(e);
		}
		
	//	System.out.println(list.size());
		
		for (Interval e: list) {
			System.out.println(e.buy+"===  "+e.sel);
		}
	 }
	
	
	public static void main(String args[]) {
		int[] arr= { 100, 180, 260, 310, 40, 535, 695 };
		getProfict(arr);
		
	}

}
