package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/7/2016.
 */
class ValuePairTest extends Specification {
    def "First"() {
        given:"valuePair instance with first =1,rest=2"
        ValuePair valuePair=new ValuePair(1,2)

        when:"invoke the getFirst method"
        String first=valuePair.getFirst()
        int first_int=Integer.valueOf(first)

        then:"the reulst is 1"
        first.equals("1")
        first_int==1


    }

    def "Rest"() {

    }
}
