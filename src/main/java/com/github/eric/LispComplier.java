package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */
public class LispComplier {

    public static int plus(int result, Object args) {
        if (args == null) {
            return result;
        }
        if (args instanceof Integer) {
            result += (Integer) args;
            return result;
        }
        if (args instanceof ValuePair) {
            Object first = ValuePairUtils.first(args);
            if (first instanceof Integer) {
                result += ((Integer) first).intValue();
            }
        }
        return plus(result, ValuePairUtils.rest(args));
    }

    public static int subtract(int result, Object args) {

            Object first = ValuePairUtils.first(args);
            Object rest = ValuePairUtils.rest(args);
            if (first instanceof Integer && rest instanceof Integer) {
                result = (Integer) first;
                return plus(result, 0 - (Integer) rest);
            }else if(first instanceof Integer&&rest instanceof ValuePair)
            {
                result=(Integer)first;
                int sum=plus(0,rest);
                return plus(result,0-sum);
            }

        return -1;
    }


    public static Object eval(ValuePair valuePair) {
        String fn = (String) valuePair.first;
        Integer rt = 0;
        if (fn != null && fn.equals("+")) {
            ValuePair args = (ValuePair) valuePair.rest;

            rt = plus(rt, args);


        }
        return rt;
    }
}
