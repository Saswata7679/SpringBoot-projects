package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //HTTP GET Request
    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Saswata",
                "Rakshit"

        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("Custom-header","mukesh")
                .body(student);
    }
    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"a","b"));
        students.add(new Student(2,"ac","bc"));
        students.add(new Student(3,"ad","bd"));

        return ResponseEntity.ok(students);
    }


    //Springboot restapi with path variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstname,
                                       @PathVariable("last-name") String lastname ){
        Student student=new Student(studentId,firstname,lastname);
        return ResponseEntity.ok(student);
    }

    //Springboot restapi with Request Param
    // http://localhost:8080/students/query?id=1&firstname=Jhulan&lastname=Rakshit

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstname,
                                          @RequestParam String lastname){
        return ResponseEntity.ok(new Student(id,firstname,lastname));
    }

    //Springboot restapi for POST REQUEST
    //@PostMapping and @RequestBody
    //http://localhost:8080/students/create
    @PostMapping("create")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }


    //Springboot restapi for PUT REQUEST
    //@PostMapping and @RequestBody
    //http://localhost:8080/students/3/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    //Springboot restapi for DELETE REQUEST
    //http://localhost:8080/students/3/delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student Deleted Successfully");
    }


}
