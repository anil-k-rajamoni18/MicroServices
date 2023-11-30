package com.example.springannotations;

import com.example.springannotations.entity.Student;
import com.example.springannotations.respository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner addStudents(StudentRepository studentRepository){
			return  args -> {
				Student student = new Student();
				student.setName("kumar");student.setAddress("hyderabad");student.setFee(192000f);student.setStream("CS");
				Student student1 = new Student();

				student1.setName("Anu");student1.setAddress("TS");student1.setFee(45000f);student1.setStream("CSI");

				studentRepository.save(student);studentRepository.save(student1);

			};
	}



}
