package hgp.lang.bootstrap.runtime;

public class Tuple<K,V> {

    private final K key;

    private final V value;

    public Tuple(K theKey, V theValue) {
        this.key = theKey;
        this.value = theValue;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
