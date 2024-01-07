
public class BitManupulation {
	
	boolean getBit(int num, int position){
		return ((num &(1<<position))!=0);
	}
	
	int setBit(int num , int position) {
		return num |(1<<position);
	}
	
	int clearBit(int num, int position){
		int clrBit= ~(1<<position);
		return num & clrBit;
	}
	
	
	int clearAllTheBitThroughMSB(int num, int position) {
		int clrBit= (1<<position)-1;
		return num & clrBit;
	}
	
	
	//N=10000000  M=1001  10001001
	void InsertMintoN(int m , int n, int j, int i){
		
		
		
	}
	
	
	void getAlternative(int n){
		
	}
	
	
	public static void main(String args[]) {
		int a=5;// 0101
		
		int x=(1<<1);
	//	int z=x-1;
		int y=a>>1;
		//int z=a<<5;
		
		System.out.println(x+" "+y);
		x=~0;
		x=x<<5;
		//Integer.BYTES
		System.out.println(Integer.BYTES);
		//System.out.println(Integer.toBinaryString(x)+"::"+Integer.toBinaryString(z));
	//	int foo = Integer.parseInt("1001", 2);
	}

}
