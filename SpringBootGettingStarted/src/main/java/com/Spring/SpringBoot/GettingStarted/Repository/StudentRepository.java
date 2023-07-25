package com.Spring.SpringBoot.GettingStarted.Repository;

import com.Spring.SpringBoot.GettingStarted.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {
}
