package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

import beans.Address;
import beans.Factory;
import beans.Location;
import beans.Status;

public class FactoryDAO {

	private HashMap<String,Factory> factories = new HashMap<String,Factory>();
	
	
	
	
	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}

	
	public FactoryDAO(String contextPath) {
		loadFactories(contextPath);
	}
	
	public Collection<Factory> getAll() {
		return factories.values();
	}
	public Factory findById(String id) {
		  if(factories.containsKey(id)){
			  return factories.get(id);
		  }
		  return new Factory();
	}
	
	public void loadFactories(String contextPath) {
        
        BufferedReader in = null;
        try {
            File file = new File(contextPath + "/factories.txt");
            System.out.println(file.getCanonicalPath());
            in = new BufferedReader(new FileReader(file));
            String line,id="", name = "", workingHours = "", statusStr = "", locationIdStr = "", logoStr = "", gradeStr = "";
            StringTokenizer st;
            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (line.equals("") || line.indexOf('#') == 0)
                    continue;
                st = new StringTokenizer(line, ";");
                if (st.countTokens() != 7) {
                  throw new IllegalArgumentException("Invalid format in products.txt: " + line);
                }
                id = st.nextToken().trim();
                name = st.nextToken().trim();
                workingHours = st.nextToken().trim();
                statusStr = st.nextToken().trim();
                locationIdStr = st.nextToken().trim();
                logoStr = st.nextToken().trim();
                gradeStr = st.nextToken().trim();

               // List<Chocolate> chocolates = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    String chocolateName = st.nextToken().trim();
                   // chocolates.add(new Chocolate(chocolateName));
                }
                

                factories.put(id, new Factory(id,name, workingHours, Status.valueOf(statusStr),Integer.parseInt(locationIdStr), logoStr, Double.parseDouble(gradeStr)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {}
            }
        }
      
    }
      
    }


	

