package JavaFeatures;


record Person(String fname, String lname, int age) {
}
public class Feature16 {
    
    public static void main(String[] args) {
        Person p=new Person("Abc", "xyz", 40);
        System.out.println(p.fname()+" "+p.toString());

    }
}

