import java.util.HashMap;

public class MyHashMap<K, V> extends AbstractMyMap<K, V> {
    protected HashMap<K, V> map = new HashMap<>();

    @Override
    public void put(K keyValue, V value) {
        map.put(keyValue, value);
    }

    @Override
    public V get(K key){
        return map.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public void replace(K key, V oldValue, V newValue){
        map.replace(key, oldValue, newValue);
    }
}
