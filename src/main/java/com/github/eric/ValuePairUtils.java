package com.github.eric;

public class ValuePairUtils {
    /**
     * Like Common Lisp first; car of a Pair, or null for anything else.
     **/
    public static Object first(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair) x).first : null;
    }

    /**
     * Like Common Lisp rest; car of a Pair, or null for anything else.
     **/
    public static Object rest(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair) x).rest : null;
    }


    public static ValuePair cons(Object a, Object b) {
        return new ValuePair(a, b);
    }
}