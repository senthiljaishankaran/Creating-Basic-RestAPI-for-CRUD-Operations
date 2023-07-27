package com.Spring.SpringBoot.GettingStarted.Controller;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import com.Spring.SpringBoot.GettingStarted.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentControllerClass.class)
class StudentControllerClassTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    private Students students;

    @BeforeEach
    void setUp() {
        students = Students.builder()
                .studentName("Senthil")
                .studentDepartment("SDET")
                .studentGrade("O")
                .studentId(1L)
                .build();
    }
    @Test
    void createStudent() throws Exception {
        Students inputStudents=Students.builder()
                .studentName("Senthil")
                .studentDepartment("SDET")
                .studentGrade("O")
                .build();
        Mockito.when(studentService.createStudent(inputStudents)).thenReturn(students);
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"studentName\":\"Senthil\",\n" +
                        "    \"studentDepartment\":\"SDET\",\n" +
                        "    \"studentGrade\":\"S\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchingById() throws Exception {
        Mockito.when(studentService.fetchingById(1L)).thenReturn(students);
        mockMvc.perform(get("/students/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(students.getStudentName()));
    }
}