import java.util.List;

public class Box <T>{
    public static <T> List<T> addtoList(List<T> list, T element){
        list.add(element);
        return list;
    }
    public static <T> List<T> deletelist(List<T> list, T elementdel){
        if(list == null || list.isEmpty()){
            return list;
        }
        else{
            list.remove(elementdel);
            return list;
        }
    }
}
