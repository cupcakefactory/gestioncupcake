package cupcake.test;

import java.util.ArrayList;
import java.util.List;

import cupcake.dao.MysqlDao;
import cupcake.entity.Client;
import cupcake.service.GestionClient;

public class TestGestionClient {
private GestionClient gestion;
	

public void init() {
	try {
		gestion = new GestionClient();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public List<Client> testGetClients(String nom,String prenom) throws Exception{
	return gestion.getClients(nom,prenom);
}
	


public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			TestGestionClient test = new TestGestionClient();
			test.init();
			try {
				
				
				System.out.println(test.testGetClients("mo",""));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


