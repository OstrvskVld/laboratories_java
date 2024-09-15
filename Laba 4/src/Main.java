import java.util.*;
import java.util.stream.Collectors;






public class Main {
//1 task
//    public static Optional<String> findX(List<String> list){
//        return list.stream()
//                .filter(s -> s != null && s.startsWith("X") && s.length() > 5)
//                .findFirst()
//                .or(() -> Optional.of("Default"));
//    }



    //2 task
//    public static List<Integer> extractIntegers(List<Optional<Integer>> optionals) {
//        return optionals.stream()
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toList());
//    }


    //3 task
//    public static Optional<String> findLongestName(List<String> names) {
//        return names.stream()
//                .filter(name -> name != null && !name.isEmpty())
//                .max(Comparator.comparingInt(String::length));
//    }


    //5 task
//    public static Optional<Integer> calculate(List<Integer> integers){
//        return integers.stream()
//                .filter(n -> n % 2 != 0)
//                .reduce((a, b) -> a * b);
//    }


    //6 task
//    public static Set<String> FriendNames(List<Person> people) {
//        return people.stream()
//                .flatMap(person -> person.getFriends().stream())
//                .map(Person::getName)
//                .map(String::toUpperCase)
//                .collect(Collectors.toSet());
//    }
    public static void main(String[] args) {
//1 task
//        List<String> strings1 = Arrays.asList("Vlad", "Karl", "Xuan");
//        List<String> strings2 = Arrays.asList("David", "Alex", "Karen", "Xuanchiko");
//        System.out.println(findX(strings1));
//        System.out.println(findX(strings2));


        //2 task
//        List<Optional<Integer>> optionals = List.of(
//                Optional.of(10),
//                Optional.empty(),
//                Optional.of(20),
//                Optional.of(30),
//                Optional.empty()
//        );
//        List<Integer> integers = extractIntegers(optionals);
//        System.out.println(integers);


        //3 task
//        List<String> names1 = List.of("Alice", "Bob", "Charlie", "David");
//        List<String> names2 = List.of("", "Eve", "", "Frank");
//        List<String> names3 = List.of();
//
//        System.out.println(findLongestName(names1));
//        System.out.println(findLongestName(names2));
//        System.out.println(findLongestName(names3));



        //4 task
//        List<Employee> employees = Arrays.asList
//                (new Employee("Alice",2900),
//                        new Employee("David",2000),
//                        new Employee("Ken",4000),
//                        new Employee("Maks",4900),
//                        new Employee("Bob",6300),
//                        new Employee("Charlie", 7200));
//        Map<String,Employee> highestSalary = employees.stream()
//                .collect(Collectors.groupingBy(employee -> {
//                            if (employee.getSalary() < 3000) {
//                                return "< 3000";
//                            } else if (employee.getSalary() >= 3000 && employee.getSalary() <= 5000) {
//                                return "3000 - 5000";
//                            } else {
//                                return "> 5000";
//                            }
//                        },
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
//                                Optional::get
//                        )
//                ));
//        System.out.println(highestSalary);


        //5 task
//        List<Integer> integers1 = Arrays.asList(1,2,3,4,5,6);
//        List<Integer> integers2 = Arrays.asList(2,4,6);
//        System.out.println(calculate(integers1));
//        System.out.println(calculate(integers2));


        //6 task
//        Person john = new Person("John", List.of(new Person("Alice", List.of()), new Person("David", List.of())));
//        Person jane = new Person("Jane", List.of(new Person("Bob", List.of()), new Person("Charlie", List.of())));
//        List<Person> people = List.of(john, jane);
//
//        Set<String> uniqueFriendNames = FriendNames(people);
//        System.out.println(uniqueFriendNames);

        }
    }
