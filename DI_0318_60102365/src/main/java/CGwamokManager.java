import java.io.IOException;


public class CGwamokManager {
	private DAO dao;
	public void gaseol(EGwamok gwamok){
		try {
			dao.write(gwamok);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//DAO와 연결됨
	}
	public DAO getDao() {
		return dao;
	}
	public void setDao(DAO dao) {
		this.dao = dao;
	}
}
