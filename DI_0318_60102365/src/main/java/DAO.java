import java.io.IOException;
import java.util.Scanner;


public class DAO {
	public void write(EGwamok gwamok) throws IOException{
		System.out.println("개설할 과목ID을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		gwamok.setName(scan.nextLine());
		System.out.println(gwamok.getName()+" 과목이 개설되었습니다.");
	}
}
