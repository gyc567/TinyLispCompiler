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


}
