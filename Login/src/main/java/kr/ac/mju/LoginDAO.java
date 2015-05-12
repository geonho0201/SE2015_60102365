package kr.ac.mju;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	
//	private User user;
//
//	public User getUser() {return user;}
//	public void setUser(User user) {this.user = user;}
	
	public User getUser(String userID, String userPassword) throws FileNotFoundException{
		User user = new User();
	File file = new File(Constants.DUSER_PATH);
	Scanner scanner = new Scanner(file);
	while(scanner.hasNext()){
		String tmp1 = scanner.next();
		String tmp2 = scanner.next();
		String tmp3 = scanner.next();
		String tmp4 = scanner.next();
		if(tmp1.equals(userID)&&tmp2.equals(userPassword)){//login success
			user.setID(tmp1);
			user.setPassword(tmp2);
			user.setName(tmp3);
			user.setType(tmp4);

			return user;
		}else if(tmp1.equals(userID)&&tmp2 != userPassword){//password error
			user.setID(tmp1);
			user.setPassword(null);
			
			return user;
		}
	}
	
	return null;//login error
}
}

