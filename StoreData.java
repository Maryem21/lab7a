
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.security.auth.login.AppConfigurationEntry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maryem
 */
public class StoreData {
     public static void main(String[] args) throws FileNotFoundException, IOException {  
		//creating configuration object  
		Configuration cfg=new Configuration() {

                };  
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
		//creating seession factory object  
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
		//creating session object  
		Session session=factory.openSession();  
			//creating transaction object  
		Transaction t=session.beginTransaction();  
		PersistantClass p1=new PersistantClass(); 
                String csvFile = "/C:/Users/Maryem/Downloads/Book1.csv";
                String line = "";
                //String cvsSplitBy = ",";
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
                    String[] products = new String[1];
                
                                //products = line.split(splitBy);
                                products = line.split(",", -1);
                                p1.setId(Integer.parseInt( products[0]));
                System.out.println("product is" +products);
                }

     }
}
           
            
//         session.persist(p1);
//               t.commit();
//	session.close();
        
        

