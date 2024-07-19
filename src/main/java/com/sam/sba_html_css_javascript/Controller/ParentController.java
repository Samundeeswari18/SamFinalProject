package com.sam.sba_html_css_javascript.Controller;

import com.sam.sba_html_css_javascript.Entity.Parent;
import com.sam.sba_html_css_javascript.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParentController {

    @Autowired
    private final ParentService parentService;


    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parentLogin")
    public String showParentLogin(Model model)
    {
        return "parentLogin";
    }

    @GetMapping("/parentDashboard")
    public String showParentDashboard() {
        return "parentDashboard";
    }

    @GetMapping("/parentRegister")
    public String showParentRegistrationForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "parentRegistrationForm"; // This assumes your template is named index.html
    }

    @PostMapping("/parentRegister")
    public String submitParentRegistrationForm(@ModelAttribute Parent parent, Model model) {
        parentService.saveParent(parent);
        return "redirect:/parentRegister?success"; // Redirect to the form page with a success parameter
    }

    @GetMapping("/registeredParents/list")
    public String showAllParentRegistration(Model model) {
        model.addAttribute("parent", parentService.getAllParents());
        return "registeredParents";
    }
}
