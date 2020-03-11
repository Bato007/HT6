
public class AbstractMyMap<K, V> implements MyMap<K, V> {

    @Override
    public void put(K keyValue, V value) {
        put(keyValue, value);
    }

    @Override
    public V get(K key){
        return get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(key);
    }

    @Override
    public void replace(K key, V oldValue, V newValue){
        replace(key, oldValue, newValue);
    }
}
