package hgp.lang.types;

public class SubrangeType<T> extends USERType{

    private final RANGEDef<T> range;

    public SubrangeType(String typeName, RANGEDef<T> range) {
        super(typeName);
        this.range = range;
    }

    @Override
    public String toString() {
        return "SubrangeType{" +
                "range=" + range +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public RANGEDef<T> range() {
        return range;
    }

    public static class RANGEDef<T> {

        private final T start;

        private final T stop;

        private final Integer typeId;

        public RANGEDef(T start, T stop, Integer typeId) {
            this.start = start;
            this.stop = stop;
            this.typeId = typeId;
        }

        public T start() {
            return start;
        }

        public T stop() {
            return stop;
        }

        public Integer typeId() {
            return typeId;
        }

        @Override
        public String toString() {
            return "RANGEDef{" +
                    "start=" + start +
                    ", stop=" + stop +
                    ", typeId=" + typeId +
                    '}';
        }
    }
}
