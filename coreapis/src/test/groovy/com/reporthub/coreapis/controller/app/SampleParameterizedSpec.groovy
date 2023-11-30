package com.reporthub.coreapis.controller.app

import com.reporthub.coreapis.app.CalculatorImpl
import spock.lang.Specification
import spock.lang.Unroll

class SampleParameterizedSpec extends Specification{

    @Unroll
    def "sample parameterized tests for calculator addition"(){
        given:
        def app = new CalculatorImpl();

        when:
        def result = app.add(input1,input2)

        then:
        result == expectedOutput

        where:
//        input1  | input2 | expectedOutput
//        10      |    20  |  30
//        -20     |    50  |  30

        input1 << [10,-40]
        input2 << [20,20]
        expectedOutput << [30,-20]

    }
}
