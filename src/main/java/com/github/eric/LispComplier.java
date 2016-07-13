package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */
public class LispComplier {

    public static int calculate(int result, Object args) {
        if (args == null) {
            return result;
        }
        if (args instanceof ValuePair) {
            Object first = ValuePairUtils.first(args);
            if (first instanceof Integer)
                result += ((Integer) first).intValue();

        }else if(args instanceof  Integer)
        {
            result+=(Integer) args;
            return result;
        }
        return calculate(result, ValuePairUtils.rest(args));
    }


    public static Object eval(ValuePair valuePair) {
        String fn = (String) valuePair.first;
        Integer rt=0;
        if (fn != null && fn.equals("+")) {
            ValuePair args = (ValuePair) valuePair.rest;

            rt= calculate(rt,args);


            return rt;
        }
        return null;
    }
}
