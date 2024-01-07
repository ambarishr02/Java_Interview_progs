package Recursion;

public class PathConstruction {
	
	static void constructPath(String str[][]){
		
		constructPathUtil(str,new String[str.length], 0 );
	}

	static void constructPathUtil(String str[][], String selected[], int currentIndex){
		if(currentIndex>=str.length){
			for (int i = 0; i < selected.length; i++) {
				System.out.print(selected[i]);
			}
			System.out.println();
			return;
		}
		for(String s: str[currentIndex]){
			selected[currentIndex]=s;
			constructPathUtil(str, selected, currentIndex+1);
		}
		return;
	}

	public static void main(String[] args) {
		String path[][]={
				{"/"},
				{"home/","etc/"},
				{"dds/","gdjshj/"}
		};
		constructPath(path);
	}
}
