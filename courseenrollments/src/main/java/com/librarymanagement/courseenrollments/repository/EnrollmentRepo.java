package com.librarymanagement.courseenrollments.repository;

import com.librarymanagement.courseenrollments.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends MongoRepository<Enrollment, Integer> {
}
