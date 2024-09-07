
import java.util.*;

public class Uniqueobj {
    public static <T> Set<T> findUnique(List<T> list) {
        Set<T> uniqueset = new LinkedHashSet<>(list);
        return uniqueset;
    }

    public static <T> Map<T, Integer> countUnique(List<T> list) {
        Map<T, Integer> uniquemap = new LinkedHashMap<>();
        for (T element : list) {
            uniquemap.put(element, uniquemap.getOrDefault(list, 0) + 1);
        }
        return uniquemap;
    }
}
