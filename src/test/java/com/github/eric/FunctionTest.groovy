package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/19/2016.
 */
class FunctionTest extends Specification {
    def "Transform #vp #function"() {
        given: "vp instance with (+ 1 2 )"
        ValuePair vp = new ValuePair("+", new ValuePair(1, 2))
        when:"call tranform method of Function"
        Function function=new Function().transform(vp)
        then:"function 's operator is + ,args is 1 2 "
        function.getOperator().equals(Operator.PLUS)
        function.getArgs().size()==2
        function.getArgs().get(0)==1
        function.getArgs().get(1)==2
    }

    def "eval  #function"() {
        given: "vp instance with (+ 1 2 )"
        ValuePair vp = new ValuePair("+", new ValuePair(1, 2))
        when:"call eval method of Function"
        Function function=new Function().transform(vp)
        Function function2=new Function().eval(function)
        then:"function 's operator is + ,args is 1 2 "
        function.getOperator().equals(Operator.PLUS)
        function.getArgs().size()==2
        function.getArgs().get(0)==1
        function.getArgs().get(1)==2
        function2.getReslut()==3
    }
}
