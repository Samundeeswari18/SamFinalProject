package com.sam.sba_html_css_javascript.Repository;


import com.sam.sba_html_css_javascript.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String username);
}
