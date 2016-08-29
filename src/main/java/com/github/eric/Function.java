package com.github.eric;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by eric567 on 7/17/2016.
 */
public class Function {
    private Operator operator;
    private List args = new ArrayList();
    private int reslut;
    private Function nextFunction;

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

     Integer numCompute(ValuePair args) {
        Integer rt = 0;
        if (this.getOperator().equals(Operator.PLUS) )
        {


            rt = plus(rt, args);


        }else if (this.getOperator().equals(Operator.SUBTRACT)) {


            rt = subtract(rt, args);


        }
        return rt;
    }

    public Function getNextFunction() {
        return nextFunction;
    }

    public void setNextFunction(Function nextFunction) {
        this.nextFunction = nextFunction;
    }

    public List getArgs() {
        return args;
    }

    public void setArgs(List args) {
        this.args = args;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }


    public int getReslut() {
        return reslut;
    }

    public void setReslut(int reslut) {
        this.reslut = reslut;
    }

    public static Function proc(Object fn)
    {
        if (fn instanceof String) {
            if (((String) fn).equalsIgnoreCase("+")) {
                Function function=new Function();
                function.setOperator(Operator.PLUS);
                return function;
            } if (((String) fn).equalsIgnoreCase("-")) {
                Function function=new Function();
                function.setOperator(Operator.SUBTRACT);
                return function;
            }
    }

        return new Function();
    }

    public  Object apply(Object args)
    {
        return numCompute((ValuePair) args);
    }


}
