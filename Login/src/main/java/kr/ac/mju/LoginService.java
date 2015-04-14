package kr.ac.mju;

import org.springframework.stereotype.Service;


@Service
public class LoginService {
	//private LoginDAO loginDao;
	
	public User login(String userID, String userPassword) {
		// TODO Auto-generated method stub
		// dao 호출
		User user = new User();
		user.setID(userID);
		user.setName("이름임");
		
		return user;
	}

	
}
