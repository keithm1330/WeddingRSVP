package com.example.demo.controller;

import com.example.demo.model.RSVPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
        sendSimpleMessage("keithsamanthaswedding@gmail.com", "WEDDING RSVP", greeting);
        return "thankyou";
    }

    @GetMapping("/rsvp")
    public String rsvp( Model model) {
        model.addAttribute("greeting", new RSVPResponse());
        return "rsvp";
    }

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, RSVPResponse text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText("People: "+text.getNames()+" attending: "+text.getAttending()+ "Message : "+text.getMessage());
        emailSender.send(message);
    }
}
