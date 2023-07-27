package com.Spring.SpringBoot.GettingStarted.Controller;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import com.Spring.SpringBoot.GettingStarted.Error.StudentNotFoundException;
import com.Spring.SpringBoot.GettingStarted.Service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControllerClass {
    @Autowired
    private StudentService studentService;
    private final Logger logger= LoggerFactory.getLogger(StudentControllerClass.class);
    @PostMapping("/students")
    public Students createStudent(@Valid @RequestBody Students students){
        logger.info("Executing the Create Student Method");
        return studentService.createStudent(students);
    }
    @GetMapping("/students")
    public List<Students> fetchingStudents(){
        logger.info("Executing the Fetch Student Method");
        return studentService.fetchingStudents();
    }
    @GetMapping("/students/{id}")
    public Students fetchingById(@PathVariable("id") Long studentsId) throws StudentNotFoundException {
        logger.info("Executing the Fetch Student By Id Method");
        return studentService.fetchingById(studentsId);
    }
    @DeleteMapping("/students/{id}")
    public String deletingById(@PathVariable("id") Long studentsId){
        logger.info("Executing the Delete Student Method");
        studentService.deletingById(studentsId);
        return "Deleted the Specified ID from DB";
    }
    @PutMapping("/students/{id}")
    public Students updatingData(@PathVariable("id") Long studentsId,@RequestBody Students students){
        logger.info("Executing the Update Student Method");
        return studentService.updatingData(studentsId,students);
    }
    @GetMapping("/students/name/{name}")
    public Students fetchStudentByName(@PathVariable("name") String studentName){
        logger.info("Executing the Fetch Student By name Method");
    return studentService.fetchStudentByName(studentName);
    }
}
