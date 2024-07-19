package com.sam.sba_html_css_javascript.Controller;

import com.sam.sba_html_css_javascript.Entity.EmailSubscription;
import com.sam.sba_html_css_javascript.Service.EmailSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSubscriptionController {
    private final EmailSubscriptionService emailSubscriptionService;

    @Autowired
    public EmailSubscriptionController(EmailSubscriptionService emailSubscriptionService) {
        this.emailSubscriptionService = emailSubscriptionService;
    }

//    @GetMapping("/index")
//    public String showIndexForm(Model model) {
//        return "index";
//    }

    @GetMapping("/index")
    public String showEmailSubscriptionForm(Model model) {
        model.addAttribute("emailSubscription", new EmailSubscription());
        return "index"; // This assumes your template is named index.html
    }

    @PostMapping("/emailSubscription")
    public String submitEmailSubscriptionForm(@ModelAttribute EmailSubscription emailSubscription) {
        emailSubscriptionService.saveEmailSubscription(emailSubscription);
        return "redirect:/index?success"; // Redirect to the form page with a success parameter
    }

    @GetMapping("/emailSubscription/list")
    public String showAllEmailSubscription(Model model) {
        model.addAttribute("emailSubscription", emailSubscriptionService.findAllEmailSubscription());
        return "emailSubscriptionList";
    }
}
