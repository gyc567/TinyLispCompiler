package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */
public class LispComplier {


    public static Object eval(Object valuePair) {
        if (valuePair == null) {
            return new Exception("Error!Empty input!");
        }
        if (!(valuePair instanceof ValuePair)) {
            return valuePair;
        }

        Object first = ValuePairUtils.first(valuePair);
        Object rest = ValuePairUtils.rest(valuePair);


        Integer rt = (Integer) Function.proc(first).apply(evalList(rest));

        return rt;
    }


    public static ValuePair evalList(Object list) {

        if (list == null)
            return null;
        else if (!(list instanceof ValuePair)) {
            System.out.println(("Illegal arg list: " + list));
            return null;
        } else
            return ValuePairUtils.cons(eval(ValuePairUtils.first(list)), evalList(ValuePairUtils.rest(list)));
    }
}
