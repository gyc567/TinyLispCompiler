package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */

public class ValuePair {
    /** The first element of the pair. **/
    public Object first;

    /** The other element of the pair. **/
    public Object rest;

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getRest() {
        return rest;
    }

    public void setRest(Object rest) {
        this.rest = rest;
    }

    /** Build a pair from two components. **/
    public ValuePair(Object first, Object rest) {
        this.first = first; this.rest = rest;
    }

    public ValuePair() {
    }


}
