package com.librarymanagement.courseenrollments.response;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResponce<A> {
    private int statusCode;
    private String statusMessage;
    private A data;
}
