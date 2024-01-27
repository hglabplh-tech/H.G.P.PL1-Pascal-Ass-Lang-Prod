package hgp.lang.bootstrap.runtime;

public class Tuple<Integer,V> {

    private final Integer key;

    private final V value;



    public Tuple(Integer addrKey, V storage) {
        this.key = addrKey;
        this.value = storage;
    }

    public Integer getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
