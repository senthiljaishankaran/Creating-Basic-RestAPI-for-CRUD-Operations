package com.Spring.SpringBoot.GettingStarted.Service;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import com.Spring.SpringBoot.GettingStarted.Repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @MockBean
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Students students=Students.builder()
                .studentId(1L)
                .studentDepartment("testing")
                .studentName("Senthil")
                .studentGrade("S")
                .build();
        Mockito.when(studentRepository.findByStudentNameIgnoreCase("Senthil")).thenReturn(students);
    }
    @Test
    @DisplayName("Unit Testing for Find Student by Name Service method")
    public void CheckingValidStudentName_IfGivenAndExpectedAreTrue(){
        String studentName="Senthil";
        Students students=studentService.fetchStudentByName(studentName);
        assertEquals(studentName,students.getStudentName());
    }
}