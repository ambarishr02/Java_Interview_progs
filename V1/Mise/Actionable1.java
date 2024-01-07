
public interface Actionable1 {
	public static boolean isActionable = true;

	public void performAction();
	
	default void printSomething() {
        System.out.println("I am inside  interface");
    }
}