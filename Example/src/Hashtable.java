public class Hashtable<K, V> {
    private K key;
    private V value;

    public Hashtable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "Hashtable{key=" + key + ", value=" + value + '}';
    }
}
