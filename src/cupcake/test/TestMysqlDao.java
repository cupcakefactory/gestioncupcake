package cupcake.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cupcake.dao.MysqlDao;
import cupcake.entity.Client;

public class TestMysqlDao {
	private MysqlDao dao;
	
	
	public void init() {
		try {
			dao = new MysqlDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public Client testGetClient(int ident) throws Exception {
		return 	dao.getClient(ident);
	}*/
	
	public ArrayList<Client> testGetClients(String nom,String prenom) throws Exception{
		return dao.getClients(nom,prenom);
	}
	
	public Client testGetCarteClient(int ident) throws Exception{
		return dao.getCarteClient(ident);
	}
	public static void main(String[] args) {
		TestMysqlDao test = new TestMysqlDao();
		test.init();
		try {
			
			//System.out.println(test.testGetClient(1));
			//System.out.println(test.testGetClients("",""));
			System.out.println(test.testGetCarteClient(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
