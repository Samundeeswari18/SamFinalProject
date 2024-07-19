package com.sam.sba_html_css_javascript.Repository;

import com.sam.sba_html_css_javascript.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Optional <Parent> findByEmail(String name);
}
