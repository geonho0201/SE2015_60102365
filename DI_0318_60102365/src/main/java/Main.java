import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext.xml"});
		
	//연결해서 과목개설을 호출 함. 프린트 아웃, 개설됐음 개설됐음 프린트아웃만 할것. 프로그램이 다섯줄도 안됨.
		CGwamokManager gwamokManager = (CGwamokManager)factory.getBean("gwamokManager");
		EGwamok gwamok = (EGwamok)factory.getBean("gwamok");
		
		gwamokManager.gaseol(gwamok);
	}

}
