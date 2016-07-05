package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */
public class Lisp {
    public int caculate(int i, int i1) {
        return i+i1;
    }

    public ValuePair wraper(String s) {
        ValuePair valuePair=new ValuePair();
        valuePair.first="+";
        return valuePair;
    }

    public Object eval(ValuePair valuePair)
    {
        String fn= (String) valuePair.first;
        if(fn!=null&&fn.equals("+"))
        {
            ValuePair args= (ValuePair) valuePair.rest;
            int arg1= Integer.valueOf((String) args.first);
            int arg2= Integer.valueOf((String) args.rest);
            Integer rt=caculate(arg1,arg2);
            return rt;
        }
        return null;
    }
}
