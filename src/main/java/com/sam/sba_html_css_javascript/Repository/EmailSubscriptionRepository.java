package com.sam.sba_html_css_javascript.Repository;

import com.sam.sba_html_css_javascript.Entity.EmailSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailSubscriptionRepository extends JpaRepository<EmailSubscription, Long> {
}
