package rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * @author hellenxu
 * @date 2018-08-01
 * Copyright 2018 Six. All rights reserved.
 */
class TestNameRule : TestRule {

    override fun apply(base: Statement?, description: Description?): Statement {
        println("xxl-test-class-name: ${description!!.className}")
        return base!!
    }
}