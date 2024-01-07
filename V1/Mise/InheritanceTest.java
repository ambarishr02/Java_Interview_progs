package Mise;

class A{
	A(){
		System.out.println("A");
	}
}

class B extends A{
	B(){
		System.out.println("B");
	}
}

class C extends B{
	C(){
		System.out.println("C");
	}
}




public class InheritanceTest {
	
	
   public static void main(String[] args) {
	   A c=new C();
}
	
	
	
}


