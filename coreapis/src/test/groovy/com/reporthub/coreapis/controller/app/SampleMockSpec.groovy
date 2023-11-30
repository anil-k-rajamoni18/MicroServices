package com.reporthub.coreapis.controller.app

import com.reporthub.coreapis.app2.StudentDatabase
import com.reporthub.coreapis.app2.StudentGradeCalculator
import spock.lang.Specification

class SampleMockSpec extends Specification{

    def mockDataBase = Mock(StudentDatabase.class)
    def app = new StudentGradeCalculator(mockDataBase);

    def "sample mock based test"(){
            given:

            when:
            app.calculateStudentGrade("123")
            then:
            1*mockDataBase.getStudentScores("123")
            1*mockDataBase.updateStudentGrade("123","C")
    }

    def "argument matchers generic"(){
        given:

        when:
        app.calculateStudentGrade("123")
        then:
        1*mockDataBase.getStudentScores(_ as String)
        1*mockDataBase.updateStudentGrade(_ as String , "C")
    }

    def "argument matchers generic with order invocation"(){
        given:

        when:
        app.calculateStudentGrade("123")
        then:
        1*mockDataBase.getStudentScores(_ as String)
        then:
        1*mockDataBase.updateStudentGrade(_ as String , "C")

    }
}
