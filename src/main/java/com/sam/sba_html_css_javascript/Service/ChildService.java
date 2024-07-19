package com.sam.sba_html_css_javascript.Service;

import com.sam.sba_html_css_javascript.Entity.Child;
import com.sam.sba_html_css_javascript.Entity.Parent;
import com.sam.sba_html_css_javascript.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Child saveChild(Child child) {
        return childRepository.save(child);
    }

    public Optional<Child> getChildById(Long childId) {
        return childRepository.findById(childId);
    }

    // Additional method for deleting a child by id
    public void deleteChildById(Long childId) {
        childRepository.deleteById(childId);
    }

    // Method to retrieve children by parent
    public List<Child> getChildrenByParent(Parent parent) {
        return childRepository.findByParent(parent);
    }
}
