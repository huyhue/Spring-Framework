package edu.poly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
    private EmailService emailService;

//    @Autowired
//    public void setMessageService(MessageService emailService) {
//        this.emailService = (EmailService) emailService;
//    }
    @Autowired 
    public ClientService(EmailService emailService) {
        super();
        this.emailService = emailService;
    }

    public void processMsg(String message) {
        emailService.sendMsg(message);
    }
}
