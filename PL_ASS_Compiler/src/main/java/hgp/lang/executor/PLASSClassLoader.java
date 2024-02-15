package hgp.lang.executor;

import clojure.lang.DynamicClassLoader;

public class PLASSClassLoader extends  ClassLoader {
    private final ClassLoader parent;
    public PLASSClassLoader() {
        parent = new DynamicClassLoader();

    }


}
