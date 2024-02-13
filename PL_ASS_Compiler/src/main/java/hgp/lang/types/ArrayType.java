package hgp.lang.types;

import com.beust.ah.A;

public class ArrayType extends USERType {
    private final ADefinition theTypeDef;

    public ArrayType(String typeName, Integer astart, Integer aend, Integer atype) {
        super(typeName);
        this.theTypeDef = new ADefinition(astart, aend, atype);
    }

    public ADefinition theTypeDef() {
        return theTypeDef;
    }

    public static class ADefinition{
        private final Integer astart;

        private final Integer aend;

        private final Integer alength;

        private final Integer atype;

        public ADefinition(Integer astart, Integer aend, Integer atype) {
            this.astart = astart;
            this.aend = aend;
            this.atype = atype;
            this.alength = (aend - astart);
        }

        public Integer astart() {
            return astart;
        }

        public Integer aend() {
            return aend;
        }

        public Integer alength() {
            return alength;
        }

        public Integer atype() {
            return atype;
        }
    }
}
