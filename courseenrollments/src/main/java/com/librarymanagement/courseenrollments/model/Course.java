package com.librarymanagement.courseenrollments.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
@Id
int courseId;

String courseName;
String courseDescription;
Double coursePrice;
String courseConductor;
@DBRef
private Student student;
}
