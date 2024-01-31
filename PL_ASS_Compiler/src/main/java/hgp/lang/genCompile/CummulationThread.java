package hgp.lang.genCompile;

import clojure.lang.Atom;
import clojure.lang.IFn;
import clojure.lang.ISeq;
import clojure.lang.Symbol;
import hgp.lang.genCompile.langblocks.BlockClassBase;

import java.util.HashMap;
import java.util.Map;

public class CummulationThread extends Thread implements Runnable {

    private IFn funToSwap = new IFn() {
        public Object invoke() {
            return null;
        }

        public Object invoke(Object o) {
            Symbol key = (Symbol)o;
            Map<Symbol, BlockClassBase> result =
                    ((Map<Symbol, BlockClassBase>)classesPool
                            .deref());
            BlockClassBase foundBlock = result.get(key);
            foundBlock.setOpenBlockClosed();
            result.put(key, foundBlock);
            return result;
        }

        public Object invoke(Object o, Object o1) {
            Symbol key = (Symbol)o;
            BlockClassBase entry = (BlockClassBase)o1;
            Map<Symbol, BlockClassBase> result =
                    ((Map<Symbol, BlockClassBase>)classesPool
                            .deref());
            result.put(key,entry);
            return result;
        }

        public Object invoke(Object o, Object o1, Object o2) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18, Object o19) {
            return null;
        }

        public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18, Object o19, Object... objects) {
            return null;
        }

        public Object applyTo(ISeq iSeq) {
            return null;
        }

        public void run() {

        }

        public Object call() throws Exception {
            return null;
        }
    };

    private Atom classesPool = new Atom( new HashMap<Symbol, BlockClassBase>());

    public void run() {
        while(true) {
            try {
                Thread.currentThread().wait(100);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread Stop /Interrupted", e);
            }
        }
    }

    public synchronized void addBlockClass (Symbol newKey, BlockClassBase newEntry) {
        // clone HashMap set value
        this.classesPool.swap(this.funToSwap, newKey, newEntry);
    }

    public synchronized void setBlockClassDone (Symbol key) {

        this.classesPool.swap(this.funToSwap, key);
    }

    public synchronized BlockClassBase getBlockEntry (Symbol key) {

        Map<Symbol, BlockClassBase> result =
                ((Map<Symbol, BlockClassBase>)classesPool
                        .deref());
        return result.get(key);
    }

    public synchronized Map<Symbol, BlockClassBase> getBlockMap () {
        Map<Symbol, BlockClassBase> result =
                ((Map<Symbol, BlockClassBase>)classesPool
                        .deref());
        return result;
    }
}
