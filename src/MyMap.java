public interface MyMap<K, V> {

    public void put(K keyValue, V value);

    public V get(K key);

    public boolean containsKey(K key);

    public void replace(K key, V oldValue, V newValue);
}
