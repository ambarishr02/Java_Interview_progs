package LamdaExpresion;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class PersonService{
  
    static List<Person> sortPersons(List<Person> list){
        Collections.sort(list, (p1, p2)-> p1.getName().compareTo(p2.getName()));
        return list;
    }
}

public class CompatatorTest {
    
   public static void main(String[] args) {
//     List<Person> persons = new ArrayList<>();
//     persons.add(new Person("John" , 23 , "USA"));
//    persons.add(new Person("Carl" , 23 , "Australia"));
//     persons.add(new Person("Amit" , 23 , "India"));
//     persons.add(new Person("Vikram" , 23 , "Bhutan"));
//     persons.add(new Person("Kane" , 23 , "Brazil"));
//     PersonService.sortPersons(persons);
//     for(Person p:persons){
//         System.out.println(p.getName());
//     }

    Supplier<Person> suplier=()-> new Person("skfj",12,"kfdsak");
    Predicate<Person> predicate=(p)->p.getAge()>18;
    
    Consumer<String> c1=(arg)-> System.out.println(arg+"1");
    Consumer<String> c2=(arg)-> System.out.println(arg+"2");
    c1.andThen(c2).accept("test");


   }
}
