package kr.ac.mju;
//60102365 이건호
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired//자동으로 만들어줌
	private LoginService service;
	
	@RequestMapping(value = "/loginController/createAccount.do", method = RequestMethod.POST)
	public String createAccount(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		String userDBID = request.getParameter("userDBID");
		String userDBPassword = request.getParameter("userDBPassword");
		service.createAccount(userDBID,userDBPassword);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/createTable.do", method = RequestMethod.POST)
	public String createTable(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.createTable();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/insertData.do", method = RequestMethod.POST)
	public String insertData(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.insertData();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/updateData.do", method = RequestMethod.POST)
	public String updateData(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.updateData();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/deleteId5.do", method = RequestMethod.POST)
	public String deleteId5(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.deleteId5();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/dropTable.do", method = RequestMethod.POST)
	public String dropTable(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.dropTable();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/dropAccount.do", method = RequestMethod.POST)
	public String dropAccount(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.dropAccount();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/selectAll.do", method = RequestMethod.POST)
	public String selectAll(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		service.selectAll();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table형태, key와 value
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");

		//login info
		//에러, 정상처리
//		LoginInfo loginInfo = service.info(userID, userPassword);
		User user = service.login(userID, userPassword);
		
		logger.info("로그인 요청 : "+userID);
		if(user == null){
			model.addAttribute("errorMsg", "존재하지 않는 아이디입니다!");
			return "loginerror";
		}else if(user.getID() != null && user.getPassword() == null){
			model.addAttribute("errorMsg", "패스워드가 일치하지 않습니다!");
			return "loginerror";
		}else if(user.getType().equals(Constants.TypeGyosu)){
			request.getSession().setAttribute("userSession", user);
			return "kangjwa";
		}else{
			request.getSession().setAttribute("userSession", user);
			return "sugang";
		}
	}
	
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "redirect:/";
	}
	
}
