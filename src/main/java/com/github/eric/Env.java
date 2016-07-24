package com.github.eric;

/**
 * Created by eric567 on 7/11/2016.
 */
public class Env {
    private Function function;
    private Env enviroment;

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Env getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(Env enviroment) {
        this.enviroment = enviroment;
    }
}
