package com.librarymanagement.courseenrollments.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
@Id
int enrollmentId;
LocalDate date;
@DBRef
private Student student;
@DBRef
private Course course;
}
