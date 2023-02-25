package com.example.demo.controller;

import com.example.demo.model.RSVPResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }
    @PostMapping("rsvp")
    public String rsvpTest(@ModelAttribute RSVPResponse greeting, Model model) {
        model.addAttribute("RSVPResponse", greeting);
        return "thankyou";
    }

    @GetMapping("/rsvp")
    public String rsvp( Model model) {
        model.addAttribute("greeting", new RSVPResponse());
        return "rsvp";
    }

//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendEmail() {
//        // use mailSender here...
//    }

}
