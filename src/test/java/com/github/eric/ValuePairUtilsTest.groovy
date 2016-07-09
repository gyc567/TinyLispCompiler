package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/9/2016.
 */
class ValuePairUtilsTest extends Specification {
    def "valuepair with 1,2 ,first method shall return 1 "() {
        given:"valuepair instance with 1,2"
        ValuePair vp=new ValuePair(1,2)
        when:"call first method of ValuepairUtils"
        Object fst=ValuePairUtils.first(vp)
        int ft=Integer.valueOf(fst)
        then:"return value is 1"
        ft==1


    }

    def "valuepair with 1,2 ,rest method shall return 2"() {

        given:"valuepair instance with 1,2"
        ValuePair vp=new ValuePair(1,2)
        when:"call first method of ValuepairUtils"
        Object fst=ValuePairUtils.rest(vp)
        int ft=Integer.valueOf(fst)
        then:"return value is 2"
        ft==2
    }
}
