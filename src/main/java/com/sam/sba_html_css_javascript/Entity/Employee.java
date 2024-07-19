package com.sam.sba_html_css_javascript.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeFirstName;
    private String employeeLastName;
    private String employeePhoneNumber;
    private String employeeEmail;
    private String employeePassword;
    private String employeeAddress;
    private String employeeCity;
    private String employeeState;
    private String employeeCountry;
    private String employeeZip;
    private LocalDate registrationDate;


    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDate.now();
    }

}
