package kr.ac.mju;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)//home이 맵핑되어있음
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );//jsp에서 ${}로 데이터를 넘겨받음
		
		return "home";//뷰 페이지의 이름,
	}
	
	@RequestMapping(value = "/loginerror", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "loginerror";
	}
	
	@RequestMapping(value = "/sugang", method = RequestMethod.GET)
	public String sugang(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "sugang";
	}
	
	@RequestMapping(value = "/gwamok", method = RequestMethod.GET)
	public String gwamok(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "gwamok";
	}
	
	@RequestMapping(value = "/kangjwa", method = RequestMethod.GET)
	public String kangjwa(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "kangjwa";
	}
	
	@RequestMapping(value = "/suganglist", method = RequestMethod.GET)
	public String suganglist(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "suganglist";
	}
	
}
