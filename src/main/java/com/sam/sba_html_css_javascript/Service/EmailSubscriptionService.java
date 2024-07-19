package com.sam.sba_html_css_javascript.Service;

import com.sam.sba_html_css_javascript.Entity.EmailSubscription;
import com.sam.sba_html_css_javascript.Repository.EmailSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSubscriptionService {

    @Autowired
    private final EmailSubscriptionRepository emailSubscriptionRepository;

    public EmailSubscriptionService(EmailSubscriptionRepository emailSubscriptionRepository) {
        this.emailSubscriptionRepository = emailSubscriptionRepository;
    }

    public EmailSubscription saveEmailSubscription(EmailSubscription emailSubscription) {
        return emailSubscriptionRepository.save(emailSubscription);
    }
    public List<EmailSubscription> findAllEmailSubscription() {
        return emailSubscriptionRepository.findAll();
    }
}
