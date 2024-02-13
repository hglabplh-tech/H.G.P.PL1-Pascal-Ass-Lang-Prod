package hgp.lang.types;

public class BaseTypesExtend extends USERType {
    public BaseTypesExtend(String typeName) {
        super(typeName);
    }

    public static class StringWithRange  {
        private final Integer range;
        public StringWithRange(int range) {
            this.range = range;
        }

        public boolean rangeCheck(String value) {
            int length = value.length();
            if (length <= range) {
                return true;
            }
            return false;
        }
    }
}
