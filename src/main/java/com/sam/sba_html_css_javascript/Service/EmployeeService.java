package com.sam.sba_html_css_javascript.Service;

import com.sam.sba_html_css_javascript.Entity.Employee;
import com.sam.sba_html_css_javascript.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;




    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        employee.setRegistrationDate(LocalDate.now());
        employee.setEmployeePassword(employee.getEmployeePassword());
        return employeeRepository.save(employee);
    }
}
