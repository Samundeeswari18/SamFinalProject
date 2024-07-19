package com.sam.sba_html_css_javascript.Repository;

import com.sam.sba_html_css_javascript.Entity.Child;
import com.sam.sba_html_css_javascript.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByParent(Parent parent);

}
