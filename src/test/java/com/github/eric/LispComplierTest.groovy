package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/11/2016.
 */
class LispComplierTest extends Specification {
    def "Caculate"() {
        given:"args is 1,2"
        int arg1=1
        int arg2=2
        when: "call caculate method"
        int rt=LispComplier.caculate(arg1,arg2)
        then:"the result shall equal 3"
        rt==3


    }

    def "Eval"() {
        given:"valuepair1 instance with 1,2,valuepair2 with + ,valuepair1"
        ValuePair vp1=new ValuePair(1,2)
        ValuePair vp2=new ValuePair("+",vp1)
        when:"call the mathod eval with valuepair2"
        Object rt=LispComplier.eval(vp2)
        int rt_int=Integer.valueOf(rt)
        then:"the result shall be 3"
        rt_int==3

    }
}
