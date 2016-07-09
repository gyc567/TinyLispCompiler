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
    def "first is +  the first method shall return +"() {
        given: "valuePair instance with first =1,rest=2"
        ValuePair valuePair = new ValuePair("+", 2)

        when: "invoke the getFirst method"
        String first = valuePair.getFirst()

        then: "the reulst is +"
        first.equals("+")



    }


    def "rest is 2 the rest method shall return 2"() {
        given: "valuepair instance with first =1,rest=2"
        ValuePair valuepair = new ValuePair(1, 2)

        when: "get the rest object value"
        String rest = valuepair.getRest()
        int rest_int = Integer.valueOf(rest)

        then: "expect the reulst is 2"
        rest.equals("2")
        rest_int == 2

    }
    def "valuepair1 is +  the rest is valuepair2 with 1,2  the rest method shall return valuepair with 1,2 "() {
        given: "valuepair1 is +,valuepair2,valuepair2 instance with first =1,rest=2"
        ValuePair valuepair2 = new ValuePair(1, 2)
        ValuePair valuepair1 = new ValuePair("+", valuepair2)

        when: "get the rest object value"
        ValuePair rest = valuepair1.getRest()


        then: "expect the reulst is 2"
        rest!=null
        rest.getFirst()==1
        rest.getRest()==2

    }
    def "valuepair1 is +  the rest is valuepair2 with 1,2 ,3 the rest method shall return valuepair with 1,2,3 "() {
        given: "valuepair1 is +,valuepair2,valuepair2 instance with first =1,rest=2"
        ValuePair valuepair3 = new ValuePair(2, 3)
        ValuePair valuepair2 = new ValuePair(1, valuepair3)
        ValuePair valuepair1 = new ValuePair("+", valuepair2)

        when: "get the rest object value"
        ValuePair rest = valuepair1.first
        int rest_first=rest.getFirst()
        ValuePair vp3=rest.getRest()


        then: "expect the reulst is 2"
        rest!=null
        vp3!=null
        rest_first==1
        vp3.getFirst()==2
        vp3.getRest()==3

    }
}
