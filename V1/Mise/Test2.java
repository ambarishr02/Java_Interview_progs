import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	
	 static char seatChar[]= {'A','B','C','D','E','F','G','H','J','k'};
	 Integer sittingArrangment[]= {3,4,3};

	 static Map<String,Integer> getCharToIntegerMap(){
		 Map<String,Integer> map=new HashMap<>();
		 for(int i=0; i<seatChar.length;i++) {
			 map.put(String.valueOf(seatChar[i]),i);
		 }
		 
		return map;
	 }
	
	static Map<Integer, List<Integer>>  genrateSeatBlockingMap(String str) {
		
		Map<Integer, List<Integer>> seatBlockMap=new HashMap<>();
		
		Map<String,Integer> seatCharMap=getCharToIntegerMap(); 
		
		if(str.length()<=1) return seatBlockMap;
	
		else {
			for(int i =0; i<str.length();) {
				if(str.charAt(i)==' ') { i++ ;continue;} 
			 char seatRow=str.charAt(i);
			 Integer seatRowNum=Integer.parseInt(String.valueOf(seatRow));
			 List<Integer> seatNumList;
			 char seatCol=str.charAt(i+1);
			 if(seatBlockMap.get(seatRowNum) != null) {
				 seatNumList=seatBlockMap.get(seatRowNum);
				seatNumList.add(seatCharMap.get(String.valueOf(seatCol)));
			 	}else {
				seatNumList=new ArrayList<>();
				seatNumList.add(seatCharMap.get(String.valueOf(seatCol)));
			 }
			 seatBlockMap.put(seatRowNum, seatNumList);
			 i+=2;
			}
		}
			
		return seatBlockMap;
	}
	
	
	
	static void  solution(int N, String s){
		
		boolean  seats[][]=new boolean[N][seatChar.length];
		Map<Integer, List<Integer>> setBlockMap=genrateSeatBlockingMap(s);
		for(int row=0;row<N;row++) {
			checkAllocationForRow(seats, row+1, setBlockMap);
		}
	}
	
	static void checkAllocationForRow(boolean  seats[][],int row,Map<Integer, List<Integer>> setBlockMap){	
		List <Integer> columList=setBlockMap.get(row);
		for(Integer seatCol:columList) {
			System.out.print(seatCol);
		}
	}
	
	
	public static void main(String args[]) {
		int N=1;
		String seatBlockStr="1A 1B 1G";
		solution(1, seatBlockStr);
	}
	
}
