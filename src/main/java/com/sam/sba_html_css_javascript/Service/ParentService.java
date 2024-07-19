package com.sam.sba_html_css_javascript.Service;
//
//import com.sam.sba_html_css_javascript.Entity.EmailSubscription;
//import com.sam.sba_html_css_javascript.Entity.Parent;
//import com.sam.sba_html_css_javascript.Repository.ParentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ParentService {
//
//    @Autowired
//    private final ParentRepository parentRepository;
//
//   public ParentService(ParentRepository parentRepository) {
//       this.parentRepository = parentRepository;
//   }
//
//    public Parent saveParent(Parent parent) {
//        return parentRepository.save(parent);
//    }
//    public List<Parent> findAllParents() {
//        return parentRepository.findAll();
//    }
//
//}


import com.sam.sba_html_css_javascript.Entity.Parent;
import com.sam.sba_html_css_javascript.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Optional<Parent> getParentById(Long parentId) {
        return parentRepository.findById(parentId);
    }

    // Additional method for deleting a parent by id
    public void deleteParentById(Long parentId) {
        parentRepository.deleteById(parentId);
    }
}
