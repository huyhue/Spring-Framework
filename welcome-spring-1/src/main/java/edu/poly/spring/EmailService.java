package edu.poly.spring;

import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailService implements MessageService{
    public void sendMsg(String message) {
        System.out.println(message);
    }

	@Override
	public void sendMsg1() {
		// TODO Auto-generated method stub
		
	}
}
