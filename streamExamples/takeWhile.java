package streamExamples;

public class takeWhile {
	
	
	public static void main(String[] args) {
		
		// List<String> alphabets=List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");
		// List<String> subset1=((Object) alphabets.stream()).takeWhile(s->s.equals("d")).collect(Collectors.toList());
		// System.out.println(subset1);
		
		// List<String> test=Arrays.asList("One","Two");
		// //test.set(1, null);
		
		// test.stream().map(s->s.toUpperCase()).forEach(System.out::println);
		
		// Stream<String> nameStream = Stream.of("mohan","john","vaibhav","amit");
		// Stream<String> nameStartJ = nameStream.map(String::toUpperCase)
		//                                     .peek( e -> System.out.println(e))
		//                                   .filter(s -> s.startsWith("J"));
		 
		// System.out.println("Calling terminal operation: count");
		// long count = nameStartJ.count();
		// System.out.println("Count: "+ count);
	}
	
	
}
