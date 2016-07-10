package com.github.eric;

/**
 * Created by eric567 on 3/8/2016.
 */
public class LispComplier {

    public static int caculate(int i, int i1) {
        return i+i1;
    }



    public static  Object eval(ValuePair valuePair)
    {
        String fn= (String) valuePair.first;
        if(fn!=null&&fn.equals("+"))
        {
            ValuePair args= (ValuePair) valuePair.rest;
            Integer arg1= (Integer) args.first;
            Integer arg2= (Integer) args.rest;
            Integer rt=caculate(arg1,arg2);
            return rt;
        }
        return null;
    }
}
