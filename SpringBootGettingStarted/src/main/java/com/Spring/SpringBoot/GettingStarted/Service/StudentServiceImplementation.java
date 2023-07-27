package com.Spring.SpringBoot.GettingStarted.Service;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import com.Spring.SpringBoot.GettingStarted.Error.StudentNotFoundException;
import com.Spring.SpringBoot.GettingStarted.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Students createStudent(Students students) {
        return studentRepository.save(students);
    }
    @Override
    public List<Students> fetchingStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Students fetchingById(Long studentsId) throws StudentNotFoundException {
        Optional<Students> students= studentRepository.findById(studentsId);
        if(!students.isPresent()){
            throw new StudentNotFoundException("Student Info Not Available");
        }
        return students.get();
    }

    @Override
    public void deletingById(Long studentsId) {
        studentRepository.deleteById(studentsId);
    }

    @Override
    public Students updatingData(Long studentsId, Students students) {
        Students studentsDatabase=studentRepository.findById(studentsId).get();
        if(Objects.nonNull(students.getStudentDepartment()) || !"".equalsIgnoreCase(students.getStudentDepartment())){
            studentsDatabase.setStudentDepartment(students.getStudentDepartment());
        }
        if(Objects.nonNull((students.getStudentGrade())) || !"".equalsIgnoreCase(students.getStudentGrade())){
            studentsDatabase.setStudentGrade(students.getStudentGrade());
        }
        if(Objects.nonNull(students.getStudentName()) || !"".equalsIgnoreCase(students.getStudentName())){
            studentsDatabase.setStudentName(students.getStudentName());
        }
        return studentRepository.save(studentsDatabase);
    }

    @Override
    public Students fetchStudentByName(String studentName) {
        return studentRepository.findByStudentNameIgnoreCase(studentName);
    }
}
