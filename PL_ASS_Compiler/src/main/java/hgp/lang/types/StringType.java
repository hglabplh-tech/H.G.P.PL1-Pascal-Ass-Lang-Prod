package hgp.lang.types;

public class StringType extends USERType{

    private final String param;

    private final ParmType pType;

    public StringType(String typeName, String param, ParmType pType) {
        super(typeName);
        this.param = param;
        this.pType = pType;
    }

    public enum ParmType {
        IDENT,
        CONST
    }
}
