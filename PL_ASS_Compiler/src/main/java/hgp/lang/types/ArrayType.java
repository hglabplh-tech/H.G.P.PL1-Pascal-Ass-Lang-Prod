package hgp.lang.types;

import com.beust.ah.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayType extends USERType {
    private final ADefinition theTypeDef  = new ADefinition();

    public ArrayType(String typeName) {
        super(typeName);
    }

    public ADefinition theTypeDef() {
        return theTypeDef;
    }

    public static class ADefinition{
        private Integer astart;

        private Integer aend;

        private Integer alength;

        private String aElementType;

        private List<String> aIndexTypes = new ArrayList<>();

        public ADefinition() {

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

        public String aElemenType() {
            return aElementType;
        }

        public List<String> aIndexTypes() {
            return aIndexTypes;
        }

        public ADefinition setAstart(Integer astart) {
            this.astart = astart;
            return this;
        }

        public ADefinition setAend(Integer aend) {
            this.aend = aend;
            return this;
        }

        public ADefinition setAlength(Integer alength) {
            this.alength = alength;
            return this;
        }

        public ADefinition setaElementType(String aElementType) {
            this.aElementType = aElementType;
            return this;
        }

        public ADefinition setaIndexTypes(List<String> aIndexTypes) {
            this.aIndexTypes = aIndexTypes;
            return this;
        }

        public ADefinition addaIndexType(String aIndexType) {
            this.aIndexTypes.add(aIndexType);
            return this;
        }
    }
}
