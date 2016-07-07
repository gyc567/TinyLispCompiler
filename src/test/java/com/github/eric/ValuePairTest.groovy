package com.github.eric

import spock.lang.Specification

/**
 * Created by eric567 on 7/7/2016.
 */
class ValuePairTest extends Specification {
    def "first is 1 the first method shall return 1"() {
        given: "valuePair instance with first =1,rest=2"
        ValuePair valuePair = new ValuePair(1, 2)

        when: "invoke the getFirst method"
        String first = valuePair.getFirst()
        int first_int = Integer.valueOf(first)

        then: "the reulst is 1"
        first.equals("1")
        first_int == 1


    }


    def "Rest"() {
        given: "valuepair instance with first =1,rest=2"
        valuepair valuepair = new valuepair(1, 2)

        when: "get the rest object value"
        string rest = valuepair.getrest()
        int rest_int = integer.valueof(rest)

        then: "expect the reulst is 2"
        rest.equals("2")
        rest_int == 2

    }
}
