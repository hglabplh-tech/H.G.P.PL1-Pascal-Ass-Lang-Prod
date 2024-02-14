package hgp.lang.types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import static hgp.lang.gparser.pl_pas_assParser.*;

public class TypeRegistry {
    private static final Integer userTypeOffset = 1000;

    private static final Map<String, USERType> typeMap = new HashMap<>();

    private static final Map<String, Integer> typeMapByTypeID = new HashMap<>();

    private static Random random = new Random(6754321);

    static {
        InternTypes.Internal type = new InternTypes.Internal(InternTypes.InternBaseTypes.REALType.name(),
                REAL, InternTypes.InternBaseTypes.REALType);
        addUserType(type.theType().name(), type);
        type = new InternTypes.Internal(InternTypes.InternBaseTypes.INTEGERType.name(),
                INTEGER, InternTypes.InternBaseTypes.INTEGERType);
        addUserType(type.theType().name(), type);
        type = new InternTypes.Internal(InternTypes.InternBaseTypes.STRINGType.name(),
                STRING, InternTypes.InternBaseTypes.STRINGType);
        addUserType(type.theType().name(), type);
        type = new InternTypes.Internal(InternTypes.InternBaseTypes.BOOLType.name(),
                BOOLEAN, InternTypes.InternBaseTypes.BOOLType);
        addUserType(type.theType().name(),  type);
    }


    public static Integer addUserType(String typeName, USERType newType) {
        Integer typeId = userTypeOffset + random.nextInt();
        typeMap.put(typeName, newType);
        typeMapByTypeID.put(typeName, typeId);
        return typeId;
    }

    public Iterator<USERType> getTypesIterator () {
        return typeMap.values().iterator();
    }


    public static USERType getType(String typeName) {
        return  typeMap.get(typeName);
    }
}
