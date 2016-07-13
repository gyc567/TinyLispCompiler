package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/11/2016.
 */
class LispComplierTest extends Specification {
    def "Caculate"() {
        given:"args is 1,2"
        ValuePair vp1=new ValuePair(1,2)
        when: "call calculate method"

        int rt=LispComplier.calculate(0,vp1)
        then:"the result shall equal 3"
        rt==3


    }

    def "Eval 1,(+ 1 2 )"() {
        given:"valuepair1 instance with 1,2,valuepair2 with + ,valuepair1"
        ValuePair vp1=new ValuePair(1,2)
        ValuePair vp2=new ValuePair("+",vp1)
        when:"call the mathod eval with valuepair2"
        Object rt=LispComplier.eval(vp2)
        int rt_int=Integer.valueOf(rt)
        then:"the result shall be 3"
        rt_int==3

    }

    def "Eval 2,(+ 1 2 3)"() {
        given:"valuepari3 with 3,null valuepair1 instance with 1,2,valuepair2 with + ,valuepair1,valuepari3"
        ValuePair vp3=new ValuePair(2,3)
        ValuePair vp1=new ValuePair(1,vp3)
        ValuePair vp2=new ValuePair("+",vp1)
        when:"call the mathod eval with valuepair2"
        Object rt=LispComplier.eval(vp2)
        int rt_int=Integer.valueOf(rt)
        then:"the result shall be 3"
        rt_int==6

    }
}
