package com.sam.sba_html_css_javascript.Controller;

import com.sam.sba_html_css_javascript.Entity.Child;
import com.sam.sba_html_css_javascript.Entity.Parent;
import com.sam.sba_html_css_javascript.Service.ChildService;
import com.sam.sba_html_css_javascript.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ParentService parentService;


    @GetMapping("/childRegister")
    public String showAddChildForm(Model model) {
        List<Parent> parents = parentService.getAllParents();
        model.addAttribute("child", new Child());
        model.addAttribute("parentId"); // Replace with actual parentId
//        model.addAttribute("parents", parents);
        return "childRegistrationForm"; // Assuming "childRegistrationForm" is your template
    }

    @PostMapping("/childRegister")
    public String saveChild(@ModelAttribute("child") Child child,
                            @RequestParam("parentId") Long parentId) {
        Optional<Parent> parent = parentService.getParentById(parentId);
        child.setParent(parent.get());
        childService.saveChild(child);
        return "redirect:/childRegister";
    }

//    @GetMapping("/registeredChildren/list")
//    public String listChildren(Model model) {
//
////        model.addAttribute("child", childService.getAllChildren());
////        return "registeredChildren";
//
//        List<Child> child = childService.getAllChildren();
//        model.addAttribute("child", child);
//        return "registeredChildren"; // Assuming "registered children.html" is your template
////    }

@GetMapping("/registeredChildren/list")
public String listChildren(Model model) {
    List<Child> children = childService.getAllChildren();
    model.addAttribute("children", children); // Use "children" instead of "child"
    return "registeredChildren"; // Ensure this is the correct template name
}

}
