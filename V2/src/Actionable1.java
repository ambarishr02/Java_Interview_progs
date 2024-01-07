
public interface Actionable1 {
	public static boolean isActionable = true;

	public void performAction();
	
	default void interfaceDefaultMethod() {
        System.out.println("I am inside  interface");
    }

	static void interFaceStaticMethod(){
		System.out.println("Static method...");
	}
}