package com.github.eric.camel

import com.github.eric.ValuePair
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by eric567 on 3/8/2016.
 */
public class ValuePairTest {

    ValuePair valuePair = null;

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test_first_value() {
        valuePair = new ValuePair();
        ValuePair vp2 = new ValuePair();
        vp2.first = "1";
        vp2.rest = "1";
        valuePair.first = "+";
        valuePair.rest = vp2;
        Assert.assertEquals("+", valuePair.first);
    }

    @Test
    public void test_rest_first_value() {
        valuePair = new ValuePair();
        ValuePair vp2 = new ValuePair();
        vp2.first = "1";
        vp2.rest = "2";
        valuePair.first = "+";
        valuePair.rest = vp2;
        ValuePair vpr = (ValuePair) valuePair.rest;
        Assert.assertEquals("1", vpr.first.toString());
        Assert.assertEquals("2", vpr.rest.toString());
    }

}