package com.six.testing

import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import rules.TestNameRule

/**
 * @author hellenxu
 * @date 2018-08-01
 * Copyright 2018 Six. All rights reserved.
 */

class CustomRuleTest {

    @JvmField @Rule
    var rule = TestNameRule()

    @Test
    fun testAdd() {
        val a = 4
        val b = 9

        assertTrue(a+b == 13)
    }
}


/*
val rule
    : private Rule rule;
    public Rule getRule();


var rule:
    : private Rule rule;
    public Rule getRule();
    public void setRule(rule);


JUnit - member "rule" is public

 */