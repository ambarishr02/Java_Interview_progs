package practise;

public class SeatAllocation {
	
	 enum setChar{
		 A("1"), B("2"),C("4"), D("8"),E("16"),F("32"),G("64"), H("128"),J("256"),K("512");
		
		 private String positionValue; 
		 
		 setChar(String str){
			 this.positionValue=str;
		 }
		 
		static int getOrdinal(String s){
			return setChar.valueOf(s).ordinal();
		 }
	 }
	
	public static int solution(int rows,String seatStr) {
		int arr[]=new int[rows];
		//if(!seatStr.isEmpty()) {
		String[] seatNumber=seatStr.split(" ");
		for(String seat:seatNumber) {
			int row=Integer.parseInt(seat.substring(0,1))-1;
			String col= seat.substring(1,2);
			
			System.out.println(row+"=== "+setChar.getOrdinal(col));
			int currentValue=arr[row];
			int postSetBit=setBit(currentValue,setChar.getOrdinal(col));
			System.out.println(currentValue+"----"+postSetBit);
			arr[row]=postSetBit;
		}
		int count=0;
		for(int i=0; i<arr.length;i++) {
			
			
			if(getBit(arr[i],5) && getBit(arr[i],6)) {
				System.out.println("No seat can be allocated in row:"+i+1);
			}
			if((arr[i]==0) || arr[i]==1  || arr[i]==512 || arr[i]==513 ) {
				count=count+2;
			}else if(!getBit(arr[i],2) && !getBit(arr[i],3) && !getBit(arr[i],4)&& !getBit(arr[i],5)) {
				count=count+1;
			}else if(!getBit(arr[i],7) && !getBit(arr[i],8) && !getBit(arr[i],5)&& !getBit(arr[i],6)) {
				count=count+1;
			}else if(!getBit(arr[i],5)&& !getBit(arr[i],6) & !getBit(arr[i],4)&& !getBit(arr[i],7)) {
				count=count+1;
			}
		}
	
		
		return count;
	}
	
	public static int solutionV2(int rows,int seats[][]) {
		int arr[]=new int[rows];
		//if(!seatStr.isEmpty()) {
	//	String[] seatNumber=seatStr.split(" ");
//		for(String seat:seatNumber) {
//			int row=Integer.parseInt(seat.substring(0,1))-1;
//			String col= seat.substring(1,2);
//			
//			System.out.println(row+"=== "+setChar.getOrdinal(col));
//			int currentValue=arr[row];
//			int postSetBit=setBit(currentValue,setChar.getOrdinal(col));
//			System.out.println(currentValue+"----"+postSetBit);
//			arr[row]=postSetBit;
//		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<seats[i].length;j++) {
		//		arr[i]=setBit(arr[i],seats[i][]);
			//	System.out.println(seats[i][j]);
			}
		}
		
		int count=0;
		for(int i=0; i<arr.length;i++) {
			
			
			if(getBit(arr[i],5) && getBit(arr[i],6)) {
				System.out.println("No seat can be allocated in row:"+i+1);
			}
			if((arr[i]==0) || arr[i]==1  || arr[i]==512 || arr[i]==513 ) {
				count=count+2;
			}else if(!getBit(arr[i],2) && !getBit(arr[i],3) && !getBit(arr[i],4)&& !getBit(arr[i],5)) {
				count=count+1;
			}else if(!getBit(arr[i],7) && !getBit(arr[i],8) && !getBit(arr[i],5)&& !getBit(arr[i],6)) {
				count=count+1;
			}else if(!getBit(arr[i],5)&& !getBit(arr[i],6) & !getBit(arr[i],4)&& !getBit(arr[i],7)) {
				count=count+1;
			}
		}
	
		
		return count;
	}
	
	
	public static int setBit(int value, int bit) {
		return (1<<bit | value);
	}
	
	
	public static boolean getBit(int value , int bit) {
		return ((1 & (value>>bit-1))==1);
	}
	
	
	
	
	public static void main(String args[]) {
		String seatBlockStr="1A ";
		//solution(1, seatBlockStr);
		int reservedSeats [][]= {{1,2},{1,3},{1,8},
								 {2,6},
								 {3,1},{3,10}};
		
		for (int i=0;i<3;i++){
			for(int j=0;j<reservedSeats[i].length;j++) {
				System.out.println(reservedSeats[i][j]);
			}
		}
		solutionV2(3,reservedSeats);
	}

}
