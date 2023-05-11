package com.example.springannotations.controller;

import com.example.springannotations.advice.LazyLoadingBean;
import com.example.springannotations.config.DBConfig;
import com.example.springannotations.config.MailProp;
import com.example.springannotations.config.TestBean;
import com.example.springannotations.entity.Student;
import com.example.springannotations.exception.StudentNotFound;
import com.example.springannotations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@PropertySource("classpath:custom.properties")
@Scope(value = "prototype")
public class StudentController {


    public StudentController(){
        System.out.println("====== STUDENT CONTROLLER BEAN ======");
    }
    @Autowired
    //@Qualifier("studentServiceImpl")
    private StudentService studentService;

    @Autowired
    private TestBean testBean;


    @Autowired
    LazyLoadingBean lazyLoadingBean;

    @Autowired
    MailProp mailProp;



    @Value("${mail.from}")
    private String from;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Value("${message}")
    private String msg;


    @GetMapping("/api/v1")
    public String greet(){
        return "greeting from annotation service ... up and running";
    }

    @PostMapping("/save")
    //@RequestMapping(value = "/save",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return  ResponseEntity.ok(studentService.add(student));
    }

    @GetMapping("/reqById")
    public ResponseEntity<Optional<Student>> getStudent(@RequestParam("id") int id) throws StudentNotFound{
        Optional<Student> student = studentService.getStudent(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student);
        }
        else{
            throw new StudentNotFound("student not found with id "+id);
        }
    }
    @GetMapping("/all")
     public List<Student> getStudent(){

        List<Student> studentList = studentService.getStudents();
        System.out.println(studentList);
        System.out.println(from +" "+host+" "+port+" "+msg);
        System.out.println(mailProp);

        testBean.method();


        return studentService.getStudents();
    }



}
