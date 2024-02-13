package hgp.lang.genCompile.memory;

import java.util.HashMap;
import java.util.Map;

public class ConstantPool {

    private  static Map<String, TypeValue> constantMap = new HashMap<>();

    public static void putConstant(String name, TypeValue constant) {
        constantMap.put(name, constant);
    }

    public static TypeValue constant(String name) {
        return constantMap.get(name);
    }

    public static class TypeValue {

        private final Integer theType;

        private final Object  value;

        public TypeValue(Integer theType, Object value) {
            this.theType = theType;
            this.value = value;
        }

        public Integer theType() {
            return theType;
        }

        public Object value() {
            return value;
        }
    }
}
