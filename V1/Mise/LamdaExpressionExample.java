import java.util.*;
import java.util.stream.Collectors;

public class LamdaExpressionExample {

    public static class Employee {

        String name;
        int age;

        public Employee(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    /*Comparator<Employee> nameComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return 0;
        }
    };*/

    public  static void  main(String[] args){
        List<Employee> listOfEmployees =createListOfEmployees();
        List<String> nameList= listOfEmployees.stream().map(e -> e.getName()).collect(Collectors.toList());
        nameList.forEach(System.out::println);

        //List to Map
       Map<String, Integer> employeeMap=listOfEmployees.stream().collect(Collectors.toMap(e -> e.getName(), e->e.getAge(),
               (oldValue, newValue) ->oldValue+newValue,HashMap::new));
       System.out.println(employeeMap);


       Map<Integer, List<String>> employeeMap1=listOfEmployees.stream().collect(Collectors.groupingBy(Employee::getAge,
               Collectors.mapping(Employee::getName,Collectors.toList())));

        Comparator<Employee> nameComparator=(Employee emp1, Employee emp2)->emp1.getName().compareTo(emp2.getName());


        Collections.sort(listOfEmployees, nameComparator);
    }

    public static List<Employee> createListOfEmployees()
    {
        List<Employee> listOfEmployees=new ArrayList<>();
        Employee emp1= new Employee("John",20);
        Employee emp2= new Employee("Martin",20);
        Employee emp3= new Employee("Mary",20);
        Employee emp4= new Employee("Steve",20);
        Employee emp5= new Employee("Steve",30);
        listOfEmployees.add(emp1);
        listOfEmployees.add(emp2);
        listOfEmployees.add(emp3);
        listOfEmployees.add(emp4);
        listOfEmployees.add(emp5);
        return listOfEmployees;
    }



}


