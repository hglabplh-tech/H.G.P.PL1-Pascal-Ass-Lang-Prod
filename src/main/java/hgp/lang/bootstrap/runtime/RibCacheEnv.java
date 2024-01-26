package hgp.lang.bootstrap.runtime;

import java.util.HashMap;
import java.util.Map;

public class RibCacheEnv {

    private static final Map<String, Address> environment = new HashMap<>();

    static class Address  {
        private final Tuple<Integer, Object> addressAndStorage;

        Address(Integer addrKey, Object storage) {
            addressAndStorage = new Tuple<Integer, Object>(addrKey, storage);
        }

        public Tuple<Integer, Object> getAddressAndStorage() {
            return addressAndStorage;
        }
    }
}
