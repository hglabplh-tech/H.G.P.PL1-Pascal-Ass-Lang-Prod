package hgp.lang.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SymbolsTable {
    private final Map<String, Integer> table = new HashMap<>();

    public SymbolsTable() {

    }

    public void putSymbol(String symName) {
        Random rand = new Random(895875764563L);
        Integer id = rand.nextInt();
        table.put(symName, id);
    }

    public Integer getSymId(String symName) {
        return table.get(symName);
    }
}
