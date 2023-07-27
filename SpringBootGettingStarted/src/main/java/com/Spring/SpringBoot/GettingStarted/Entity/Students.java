package com.Spring.SpringBoot.GettingStarted.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @NotBlank(message = "Student Name Should not be Empty")
    private String studentName;
    private String studentDepartment;
    private String studentGrade;

}
