package com.librarymanagement.courseenrollments.controller;

import com.librarymanagement.courseenrollments.model.Course;
import com.librarymanagement.courseenrollments.model.Student;
import com.librarymanagement.courseenrollments.response.ReturnResponce;
import com.librarymanagement.courseenrollments.service.EnrollmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ApplicationManagement")
@Validated
public class EnrollmentController {
    @Autowired
    EnrollmentServices enrollmentServices;

    @GetMapping("/studentDetail/{studentId}")
        public Student studentDetail(@PathVariable Integer studentId){
        return enrollmentServices.studentDetail(studentId);

    }
    @GetMapping("/courseDetails/{courseId}")
    public Course courseDetail(@PathVariable Integer courseId){
   return enrollmentServices.courseDetail(courseId);
    }
    @PostMapping("/courseEnrollment")
    public ResponseEntity<ReturnResponce> courseEnrollment(@RequestParam Integer studentId,@RequestParam int accountNumber, @RequestBody List<Course> courseList){
      return enrollmentServices.courseEnrollment(studentId,accountNumber, courseList);
    }
}
