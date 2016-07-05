package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */

public class ValuePair {
    /** The first element of the pair. **/
    public Object first;

    /** The other element of the pair. **/
    public Object rest;

    /** Build a pair from two components. **/
    public ValuePair(Object first, Object rest) {
        this.first = first; this.rest = rest;
    }





    /** Like Common Lisp first; car of a Pair, or null for anything else. **/
    public static Object first(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair)x).first : null;
    }

    /** Like Common Lisp rest; car of a Pair, or null for anything else. **/
    public static Object rest(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair)x).rest : null;
    }





}
