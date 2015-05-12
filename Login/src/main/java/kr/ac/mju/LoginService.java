package kr.ac.mju;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDao;
	
	public User login(String userID, String userPassword) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// dao 호출
		return loginDao.getUser(userID, userPassword);
	}
}
