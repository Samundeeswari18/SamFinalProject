package com.sam.sba_html_css_javascript.Service;


import com.sam.sba_html_css_javascript.Entity.ContactMessage;
import com.sam.sba_html_css_javascript.Repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Autowired
    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public void saveMessage(ContactMessage message)
    {
        contactMessageRepository.save(message);
    }

    public List<ContactMessage> getAllMessages()
    {
        return contactMessageRepository.findAll();
    }
}

