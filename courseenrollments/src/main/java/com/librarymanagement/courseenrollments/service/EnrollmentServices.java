package com.librarymanagement.courseenrollments.service;

import com.librarymanagement.courseenrollments.client.BankClient;
import com.librarymanagement.courseenrollments.model.Course;
import com.librarymanagement.courseenrollments.model.Enrollment;
import com.librarymanagement.courseenrollments.model.Student;
import com.librarymanagement.courseenrollments.repository.CourseRepo;
import com.librarymanagement.courseenrollments.repository.EnrollmentRepo;
import com.librarymanagement.courseenrollments.repository.StudentRepo;
import com.librarymanagement.courseenrollments.response.ReturnResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServices {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    EnrollmentRepo enrollmentRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    BankClient bankClient;

    public Student studentDetail(Integer studentId) {

        return studentRepo.findByStudentId(studentId);

    }

    public Course courseDetail(Integer courseId) {
        return courseRepo.findByCourseId(courseId);

    }

    public ResponseEntity<ReturnResponce> courseEnrollment(Integer studentId,int accountNumber, List<Course> courseList) {
        double totalAmount = 0.00;
        Student student = studentRepo.findByStudentId(studentId);
        List<Enrollment> enrollmentList = new ArrayList<>();
        for (Course course : courseList) {
            int courseId = course.getCourseId();
            Course course1 = courseDetail(courseId);
            totalAmount = totalAmount + course1.getCoursePrice();
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course1);
            enrollment.setDate(LocalDate.now());
            enrollmentList.add(enrollment);

        }
        //call payment service
        String response = bankClient.fundTransfer(studentId, accountNumber, 987654321, "SBI0089765", totalAmount);
        if (!response.equals("fund transfer sucessfull")) {
            ReturnResponce returnResponce = new ReturnResponce();
            returnResponce.setStatusCode(500);
            returnResponce.setStatusMessage("insufficient fund");
            returnResponce.setData(null);
            return new ResponseEntity<>(returnResponce, HttpStatus.INTERNAL_SERVER_ERROR);

        }
            try {
                enrollmentRepo.saveAll(enrollmentList);
                ReturnResponce returnResponce = new ReturnResponce();
                returnResponce.setStatusCode(200);
                returnResponce.setStatusMessage("Enrolled in course successfully");
                returnResponce.setData(enrollmentList);
                return ResponseEntity.ok(returnResponce);
            } catch (Exception ex) {
                throw ex;
            }
        }


}
