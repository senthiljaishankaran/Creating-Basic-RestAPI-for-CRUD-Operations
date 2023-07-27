package com.Spring.SpringBoot.GettingStarted.Repository;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Students student=Students.builder().
                studentName("Suresh").
                studentDepartment("Testing").
                studentGrade("A")
                .build();
        testEntityManager.persist(student);
    }
    @Test
    public void CheckingIfTheActualAndExpectedDepartmentIsSame(){
        Students student=studentRepository.findById(1L).get();
        assertEquals(student.getStudentDepartment(),"Testing");
    }
}