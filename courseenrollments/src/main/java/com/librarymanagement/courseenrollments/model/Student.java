package com.librarymanagement.courseenrollments.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    int studentId;
    String studentName;
    String studentSchool;
    String studentDivision;
    String studentEmail;
    String studentPassword;
}
