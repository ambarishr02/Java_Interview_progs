import java.util.Collection;

public class InterFaceTest implements Actionable1 {

	public void performAction() {
		// Code that depends on isActionable variable
		if (isActionable) {
			System.out.println("Example-1");
		}
	}

	public void printSomething() {
        System.out.println("I am inside B interface");
    }
	public static void main(String[] args) {

		InterFaceTest test = new InterFaceTest();

		test.performAction();
		test.printSomething();
		
		//Collection.sort(Persons,(p1, p2)->{p1.getName())
		
	}

}
