package com.github.eric;

import java.util.List;

/**
 * Created by eric567 on 7/17/2016.
 */
public class Function {
    private Operator operator;
    private List args;
    private int reslut;

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

        Object first = valuePair.first;
        if(first instanceof String)
        {
            if(((String) first).equalsIgnoreCase("+"))
            {
                Function function=new Function();
                function.setOperator(Operator.PLUS);
            }
        }
        return null;
    }

}
