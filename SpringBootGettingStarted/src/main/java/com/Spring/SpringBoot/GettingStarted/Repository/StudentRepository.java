package com.Spring.SpringBoot.GettingStarted.Repository;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {
    /*
    Jpa Repository has only limited method available in it
    But some we May require a custom Method for certain application
    So they provide us with a feature to write custom methods in the child repository that extends JPA repository
    Like the methods that we have written below
    If the Method to store in the repo is so complex, we can also one more option provide by Spring JPA ie.. Custom Query

    link to the doc is "https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html"

    Query will be like

    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
    User findByEmailAddress(String emailAddress);
     */
    public Students findByStudentName(String studentName);
    public Students findByStudentNameIgnoreCase(String studentName);
}
