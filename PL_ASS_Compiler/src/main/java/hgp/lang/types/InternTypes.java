package hgp.lang.types;

import com.ibm.icu.lang.CharSequences;

import static hgp.lang.gparser.pl_pas_assParser.*;

public class InternTypes {

    public static class Internal extends USERType {

        private final InternBaseTypes theType;

        private final Integer typeId;

        public Internal(String typeName, Integer typeId, InternBaseTypes theType) {
            super(typeName);
            this.typeId = typeId;
            this.theType = theType;
        }

        public InternBaseTypes theType() {
            return theType;
        }
    }

    public  enum InternBaseTypes {
        REALType(REAL, Double.class),
        INTEGERType(INTEGER, Integer.class),
        BOOLType(BOOLEAN, Boolean.class),

        STRINGType(STRING, String.class)
        ;

        private final Integer typeId;

        private final Class javaTyp;

        InternBaseTypes(Integer typeId, Class javaType){
            this.typeId = typeId;
            this.javaTyp = javaType;
        }

        public Integer typeId() {
            return typeId;
        }

        public Class javaTyp() {
            return javaTyp;
        }
    }
}
