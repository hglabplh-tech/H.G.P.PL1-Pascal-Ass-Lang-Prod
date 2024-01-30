package hgp.lang.runtime;

import hgp.lang.utils.Tuple;

import java.util.*;

public class RibCageEnv {

    private static RibCageEnv instance = null;


    private static final List<Map<Integer, Address>> env = new ArrayList<>();

    private final List<Map<Integer, Address>> stackEnv;

    public RibCageEnv(List<Map<Integer, Address>> newEnv) {
        stackEnv = newEnv;
    }
    public void pushStackEnv(Map<Integer, Address> newSub) {
        stackEnv.add(0, newSub);
    }

    public Map<Integer, Address> popStackEnv() {
        stackEnv.remove(0);
        Map<Integer, Address>  result = stackEnv.get(0);
        return result;
    }

    public static RibCageEnv getInstance() {
        if (instance == null) {
            return new RibCageEnv(env);
        }
        return instance;
    }

    public Optional<Map<Integer, Address>> giveCheckedEnv() {
        return (!stackEnv.isEmpty()) ?
                Optional.of(stackEnv.get(0)) :
                Optional.empty();
    }

    public Address getStorValue(Integer key) {
        Optional<Map<Integer, Address>> addressMap = giveCheckedEnv();
        if (addressMap.isPresent()) {
            return addressMap.get().get(key);
        }
        return null;

    }

    public void putStorValue(Integer key, Object value) {
        Optional<Map<Integer, Address>> addressMap = giveCheckedEnv();
        if (addressMap.isPresent()) {
            Address<Integer, Object> tuple = new Address<>(key, value);
            addressMap.get().put(key, tuple);
        }
    }


    public void removeStor(Integer key) {
        Optional<Map<Integer, Address>> addressMap = giveCheckedEnv();
        if (addressMap.isPresent()) {
            addressMap.get().remove(key);
        }
    }


    public static class Address<Integer, A>  {
        private final Tuple<Integer, A> addressAndStorage;

        public Address(Integer addrKey, A storage) {
            addressAndStorage = new Tuple<Integer, A>(addrKey, storage);
        }

        public Tuple<Integer, A> getAddressAndStorage() {
            return addressAndStorage;
        }
    }
}
