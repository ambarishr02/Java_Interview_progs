package Threads;


class Table {
	
	 synchronized void printtable(int n) {
	
	for(int i=1;i<=5;i++) {
		System.out.println(n*i);
		
		 try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  
		}
		//printTwo(n);
	}
	 
	 
//	 void printTwo(int n){
//		 for(int i=1;i<=2;i++) {
//				System.out.println(n*i);
//				 try{  
//				      Thread.sleep(400);  
//				     }catch(Exception e){System.out.println(e);}  
//				}
//	 }
}


class RunnableTh implements Runnable{
	
	Table table;
	int n;
	
	 RunnableTh(Table table, int n){
	 this.table=table;
	 this.n=n;
	}

	@Override
	public void run() {
		table.printtable(n);	
	}
	
}

public class Sync {
	
	public static void main(String[] args) {
		
		Table t=new Table();
		
		Thread t1=new Thread(new RunnableTh(t, 5));
		Thread t2=new Thread(new RunnableTh(t, 100));
		
		t1.start();
		t2.start();
	}
	
}
