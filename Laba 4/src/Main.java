import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static Optional<String> findX(List<String> list){
        return list.stream()
                .filter(s -> s != null && s.startsWith("X") && s.length() > 5)
                .findFirst()
                .or(() -> Optional.of("Default"));
    }
    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("Vlad", "Karl", "Xuan");
        List<String> strings2 = Arrays.asList("David", "Alex", "Karen", "Xuanchiko");
        System.out.println(findX(strings1));
        System.out.println(findX(strings2));
        }
    }
