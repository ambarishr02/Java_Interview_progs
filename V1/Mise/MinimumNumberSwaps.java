import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MinimumNumberSwaps {
	
	static int numberOfSwipes (int arr[]){
		
		int n=arr.length;
		boolean visited[]=new boolean[n+1];
		Map<Integer, Integer> map=new HashMap<>();
		int count=0;
		for (int i=1;i<=arr.length;i++) {
			map.put(i, arr[i-1]);
		}
		
		for(int i=1;i<=map.size();i++) {
			
				if(!visited[i]) {
					visited[i]=true;
					if(map.get(i)==i) {
						continue;
					}else {
					 int current=map.get(i);
					 while(!visited[current]) {
						 count++;
						 visited[current]=true;
						 current=map.get(current);
					 }
					}
			}
		}
		return count;		
	}

	
	public static void main(String args[]) {
		int[] arr= {1,4,5,2,3};
		//System.out.println()
		System.out.println (""+numberOfSwipes(arr));
		
	}
}
