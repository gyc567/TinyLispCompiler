package com.github.eric;

import java.util.List;

public class FunctionUtils {
    public static Function transform(ValuePair valuePair) {
        if (valuePair.first == null)
            return null;

        Object first = ValuePairUtils.first(valuePair);
        Object rest = ValuePairUtils.rest(valuePair);
        Function function = new Function();
        if (first instanceof String) {
            if (((String) first).equalsIgnoreCase("+")) {

                function.setOperator(Operator.PLUS);
            } else if (((String) first).equalsIgnoreCase("-")) {
                function.setOperator(Operator.SUBTRACT);
            }
        }
        if (rest instanceof ValuePair) {
            ValuePair vp = (ValuePair) rest;

            function = travleValuePair(function, vp);
        }
        return function;
    }

    private static Function travleValuePair(Function function, ValuePair vp) {
        if (vp == null || vp.first == null)
            return function;

        Object first = vp.first;
        function.getArgs().add(first);
        if (vp.rest
                != null)
            function.getArgs().add(vp.rest);
        return function;
    }

    public static Function eval(Function function) {
        int rt = 0;
        List<Integer> args = function.getArgs();
        if (function.getOperator().equals(Operator.PLUS)) {


            for (Integer arg : args) {
                rt += arg;
            }

        } else if (function.getOperator().equals(Operator.SUBTRACT)) {
            Integer sum = args.get(0);
            int n = 0;
            for (int i = 1; i < args.size(); i++) {
                Integer integer = args.get(i);
                n += integer;
            }
            rt = sum - n;
        }
        function.setReslut(rt);
        return function;
    }
}