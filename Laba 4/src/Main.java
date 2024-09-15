import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

        }
    }
