package com.github.eric;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric567 on 7/17/2016.
 */
public class Function {
    private Operator operator;
    private List args=new ArrayList();
    private int reslut;

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

    public Function transform(ValuePair valuePair)
    {
    if(valuePair.first==null)
        return null;

        Object first = ValuePairUtils.first(valuePair);
        Object rest = ValuePairUtils.rest(valuePair);
        Function function=new Function();
        if(first instanceof String)
        {
            if(((String) first).equalsIgnoreCase("+"))
            {

                function.setOperator(Operator.PLUS);
            }
        }
        if(rest instanceof ValuePair)
        {
            ValuePair vp= (ValuePair) rest;
            function=travleValuePair(function,vp);
        }
        return function;
    }

    private Function travleValuePair(Function function, ValuePair vp) {
        if (vp==null||vp.first==null)
            return function;

        Object first = vp.first;
        function.getArgs().add(first);
        if(vp.rest
                !=null)
            function.getArgs().add(vp.rest);
        return function;
    }

}
