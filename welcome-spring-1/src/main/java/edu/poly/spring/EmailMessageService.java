package edu.poly.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class EmailMessageService implements MessageService {

    @Override
    public void sendMsg1() {
        System.out.println("gửi bằng email");
    }

	@Override
	public void sendMsg(String message) {
		// TODO Auto-generated method stub
		
	}
}
