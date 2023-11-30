package com.reporthub.coreapis.controller.app

import com.reporthub.coreapis.app2.IStudentDatabase
import com.reporthub.coreapis.app2.StudentGradeCalculator
import spock.lang.Specification

class SampleStubSpec extends Specification {

    //stubs
    def studentDatabaseStub = Stub(IStudentDatabase.class)
    def app = new StudentGradeCalculator(studentDatabaseStub)

    def "sample stub test"(){
        given:
        studentDatabaseStub.getGrade("123") >> "A"
        //studentDatabaseStub.getStudentScores("123") >> [40F,30F,30F]

        when:
        def grade = app.calculateStudentGrade("123")

        then:
        grade == "A"
    }
}
