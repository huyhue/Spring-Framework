package edu.poly.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class FacebookMessageService implements MessageService {

    @Override
    public void sendMsg1() {
        System.out.println("gửi bằng facebook");
    }

	@Override
	public void sendMsg(String message) {
		// TODO Auto-generated method stub
		
	}
}
