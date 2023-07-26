package com.Spring.SpringBoot.GettingStarted.Controller;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import com.Spring.SpringBoot.GettingStarted.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControllerClass {
    @Autowired
    private StudentService studentService;
    @PostMapping("/students")
    public Students createStudent(@RequestBody Students students){
        return studentService.createStudent(students);
    }
    @GetMapping("/students")
    public List<Students> fetchingStudents(){
        return studentService.fetchingStudents();
    }
    @GetMapping("/students/{id}")
    public Students fetchingById(@PathVariable("id") Long studentsId){
        return studentService.fetchingById(studentsId);
    }
    @DeleteMapping("/students/{id}")
    public String deletingById(@PathVariable("id") Long studentsId){
        studentService.deletingById(studentsId);
        return "Deleted the Specified ID from DB";
    }
    @PutMapping("/students/{id}")
    public Students updatingData(@PathVariable("id") Long studentsId,@RequestBody Students students){
        return studentService.updatingData(studentsId,students);
    }
    @GetMapping("/students/name/{name}")
    public Students fetchStudentByName(@PathVariable("name") String studentName){
    return studentService.fetchStudentByName(studentName);
    }
}
