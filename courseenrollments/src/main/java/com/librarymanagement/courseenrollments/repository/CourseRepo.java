package com.librarymanagement.courseenrollments.repository;

import com.librarymanagement.courseenrollments.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends MongoRepository<Course, Integer> {
    Course findByCourseId(int courseId);
}
