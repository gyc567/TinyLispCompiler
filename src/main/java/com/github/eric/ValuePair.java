package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */

public class ValuePair {


    /** Same as Boolean.TRUE. **/
    public static final Boolean TRUE = Boolean.TRUE;
    /** Same as Boolean.FALSE. **/
    public static final Boolean FALSE = Boolean.FALSE;

    public static Double ZERO = new Double(0.0);
    public static Double ONE = new Double(1.0);
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


    /** Like Common Lisp first; car of a ValuePair, or null for anything else. **/
    public static Object first(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair)x).first : null;
    }

    /** Like Common Lisp rest; car of a ValuePair, or null for anything else. **/
    public static Object rest(Object x) {
        return (x instanceof ValuePair) ? ((ValuePair)x).rest : null;
    }
    /** Like Common Lisp second. **/
    public static Object second(Object x) {
        return first(rest(x));
    }

    /** Like Common Lisp third. **/
    public static Object third(Object x) {
        return first(rest(rest(x)));
    }

    /** Check if two objects are equal. **/
    public static boolean equal(Object x, Object y) {
        if (x == null || y == null) {
            return x == y;
        } else if (x instanceof char[]) {
            if (!(y instanceof char[])) return false;
            char[] xc = (char[])x, yc = (char[])y;
            if (xc.length != yc.length) return false;
            for (int i = xc.length - 1; i >= 0; i--) {
                if (xc[i] != yc[i]) return false;
            }
            return true;
        } else if (x instanceof Object[]) {
            if (!(y instanceof Object[])) return false;
            Object[] xo = (Object[])x, yo = (Object[])y;
            if (xo.length != yo.length) return false;
            for (int i = xo.length - 1; i >= 0; i--) {
                if (!equal(xo[i],yo[i])) return false;
            }
            return true;
        } else {
            return x.equals(y);
        }
    }
    /** Two pairs are equal if their first and rest fields are equal. **/
    public boolean equals(Object x) {
        if (x == this) return true;
        else if (!(x instanceof ValuePair)) return false;
        else {
            ValuePair that = (ValuePair)x;
            return equal(this.first, that.first)
                    && equal(this.rest, that.rest);
        }
    }

    /** Return a String representation of the pair. **/
    public String toString() { return stringify(this, true); }
    /** Convert x to a Java String giving its external representation.
     * Strings and characters are quoted. **/
    static String stringify(Object x) { return stringify(x, true); }

    /** Convert x to a Java String giving its external representation.
     * Strings and characters are quoted iff <tt>quoted</tt> is true.. **/
    static String stringify(Object x, boolean quoted) {
        StringBuffer buf = new StringBuffer();
        stringify(x, quoted, buf);
        return buf.toString();
    }
    /** Convert a Scheme object to its printed representation, as
     * a java String (not a Scheme string). If quoted is true, use "str" and #\c,
     * otherwise use str and c. You need to pass in a StringBuffer that is used
     * to accumulate the results. (If the interface didn't work that way, the
     * system would use lots of little internal StringBuffers.  But note that
     * you can still call <tt>stringify(x)</tt> and a new StringBuffer will
     * be created for you. **/

    static void stringify(Object x, boolean quoted, StringBuffer buf) {
        if (x == null)
            buf.append("()");
        else if (x instanceof Double) {
            double d = ((Double)x).doubleValue();
            if (Math.round(d) == d) buf.append((long)d); else buf.append(d);
        } else if (x instanceof Character) {
            if (quoted) buf.append("#\\");
            buf.append(x);
        } else if (x instanceof ValuePair) {
            ((ValuePair)x).stringifyPair(quoted, buf);
        } else if (x instanceof char[]) {
            char[] chars = (char[])x;
            if (quoted) buf.append('"');
            for (int i = 0; i < chars.length; i++) {
                if (quoted && chars[i] == '"') buf.append('\\');
                buf.append(chars[i]);
            }
            if (quoted) buf.append('"');
        } else if (x instanceof Object[]) {
            Object[] v = (Object[])x;
            buf.append("#(");
            for (int i=0; i<v.length; i++) {
                stringify(v[i], quoted, buf);
                if (i != v.length-1) buf.append(' ');
            }
            buf.append(')');
        } else if (x == TRUE) {
            buf.append("#t");
        } else if (x == FALSE) {
            buf.append("#f");
        } else {
            buf.append(x);
        }
    }


    /** Build up a String representation of the ValuePair in a StringBuffer. **/
    void stringifyPair(boolean quoted, StringBuffer buf) {
        String special = null;
        if ((rest instanceof ValuePair) && rest(rest) == null)
            special = (first == "quote") ? "'" : (first == "quasiquote") ? "`"
                    : (first == "unquote") ? "," : (first == "unquote-splicing") ? ",@"
                    : null;

        if (special != null) {
            buf.append(special); stringify(second(this), quoted, buf);
        } else {
            buf.append('(');
            stringify(first, quoted, buf);
            Object tail = rest;
            while (tail instanceof ValuePair) {
                buf.append(' ');
                stringify(((ValuePair)tail).first, quoted, buf);
                tail = ((ValuePair)tail).rest;
            }
            if (tail != null) {
                buf.append(" . ");
                stringify(tail, quoted, buf);
            }
            buf.append(')');
        }
    }


}
