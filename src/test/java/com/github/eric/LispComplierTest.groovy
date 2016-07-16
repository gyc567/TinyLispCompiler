package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/11/2016.
 */
class LispComplierTest extends Specification {
    def "Caculate for valuepair with 1,2"() {
        given: "args is 1,2"
        ValuePair vp1 = new ValuePair(1, 2)
        when: "call plus method"

        int rt = LispComplier.plus(0, vp1)
        then: "the result shall equal 3"
        rt == 3


    }

    def "subtract for #vp1,#rtValue"() {

        expect:
        rtValue == LispComplier.subtract(0, vp1)
        where:
        vp1                                                     | rtValue
        new ValuePair(3, 2)                                     | 1
        new ValuePair(3, 0)                                     | 3
        new ValuePair(3, 1)                                     | 2
        new ValuePair(4, 2)                                     | 2
        new ValuePair(8, new ValuePair(2, 3))                   | 3
        new ValuePair(9, new ValuePair(2, new ValuePair(2, 3))) | 2

    }

    def "Caculate for valuepair with 1,2,3"() {

        given: "args is 1,and 2,3"


        ValuePair vp1 = new ValuePair(1, new ValuePair(2, 3))

        when: "call plus method"

        int rt = LispComplier.plus(0, vp1)

        then: "the result shall equal 6"
        rt == 6


    }

    def "Eval 1,(+ 1 2 )"() {
        given: "valuepair1 instance with 1,2,valuepair2 with + ,valuepair1"
        ValuePair vp1 = new ValuePair(1, 2)
        ValuePair vp2 = new ValuePair("+", vp1)
        when: "call the mathod eval with valuepair2"
        Object rt = LispComplier.eval(vp2)
        int rt_int = Integer.valueOf(rt)
        then: "the result shall be 3"
        rt_int == 3

    }

    def "Eval (+ 1 9 )"() {
        given: "valuepair1 instance with 1,2,valuepair2 with + ,valuepair1"
        ValuePair vp2 = new ValuePair("+", new ValuePair(1, 9))
        when: "call the mathod eval with valuepair2"
        Object rt = LispComplier.eval(vp2)
        int rt_int = Integer.valueOf(rt)
        then: "the result shall be 3"
        rt_int == 10

    }

    def "Eval 2,(+ 1 2 3)"() {
        given: "valuepari3 with 3,null valuepair1 instance with 1,2,valuepair2 with + ,valuepair1,valuepari3"
        ValuePair vp3 = new ValuePair(2, 3)
        ValuePair vp1 = new ValuePair(1, vp3)
        ValuePair vp2 = new ValuePair("+", vp1)
        when: "call the mathod eval with valuepair2"
        Object rt = LispComplier.eval(vp2)
        int rt_int = Integer.valueOf(rt)
        then: "the result shall be 3"
        rt_int == 6

    }
}
