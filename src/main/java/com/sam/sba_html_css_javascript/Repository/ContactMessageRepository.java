package com.sam.sba_html_css_javascript.Repository;


import com.sam.sba_html_css_javascript.Entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}


