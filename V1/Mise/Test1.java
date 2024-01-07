import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class Test1 {
	
	
	public static long  pair(int a[]) {
		Map<Integer, List<Integer>> map=new HashMap<>();
		long pairCount=0;
		 if(a.length==0||a.length==1)
			 return 0;
		
		 for(int i=0; i<a.length;i++) {
			 if(map.containsKey(a[i])) {
			   List<Integer> positionList=map.get(a[i]);
			    if(!positionList.contains(i)) {
			    	positionList.add(i);
			     map.put(a[i],positionList);
			   }
			 }else {
				 List <Integer> list=new ArrayList<>();
				 list.add(i);
				 map.put(a[i], list);
			 }
			
		 }
		 for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
		    	if(entry.getValue()!=null)
				pairCount+=nCr(entry.getValue().size(),2);
          			
		 }
		 return pairCount;
		 
	}
		
	static int nCr(int n, int r) 
	{ 
	    return fact(n) / (fact(r) * 
	                  fact(n - r)); 
	} 
	  	
	static int fact(int n) 
	{ 
	    int res = 1; 
	    for (int i = 2; i <= n; i++) 
	        res = res * i; 
	    return res; 
	} 
	
	public static void main(String args[]) {
		int a[]= {3,5,6,3,3,5};
		System.out.println(pair(a));
		
	}

}
