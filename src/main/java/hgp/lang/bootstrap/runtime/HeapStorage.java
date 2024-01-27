package hgp.lang.bootstrap.runtime;

public class HeapStorage {

    RibCageEnv myEnv = RibCageEnv.getInstance();

    public HeapStorage() {

    }

    public byte [] untypedAlloc(Integer id, Integer size) {
        byte [] allocated = new byte[size];
        myEnv.putStorValue(id, allocated);
        return new byte[size];
    }

    public <T> HeapElement<T> typedAlloc(Integer id, T value)  {
        HeapElement<T> allocated = new HeapElement<T>(value);
        myEnv.putStorValue(id, allocated); // correct it
        return allocated;
    }

    public void free(Integer id) {
        myEnv.removeStor(id);
    }

    public <T> T getValue(Integer id) {
        return (T)myEnv.getStorValue(id);
    }

    public static class HeapElement<H> {
        private final H theValue;
        public HeapElement(H value) {
            this.theValue = value;
        }

        public H getTheValue() {
            return theValue;
        }

    }

}
