package com.Spring.SpringBoot.GettingStarted.Service;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;

import java.util.List;

public interface StudentService {
    public Students createStudent(Students students);

    public List<Students> fetchingStudents();

    public Students fetchingById(Long studentsId);

    public void deletingById(Long studentsId);

    public Students updatingData(Long studentsId, Students students);

    public Students fetchStudentByName(String studentName);
}
