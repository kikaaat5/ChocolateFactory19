package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.Address;
import beans.Location;

public class AddressDAO {

	public HashMap<Integer,Address> addresses = new HashMap<Integer,Address>();
	
	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public AddressDAO(String contextPath) {
		loadAddresses(contextPath);
	}
	
	public Collection<Address> getAll() {
		return addresses.values();
	}
	
	public Address findById(int id) {
		  if(addresses.containsKey(id)){
			  return addresses.get(id);
		  }
		  return new Address();
	}
	
	private void loadAddresses(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/addresses.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", street = "", number = "", city="",postcode="";
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					street = st.nextToken().trim();
					number = st.nextToken().trim();
					city = st.nextToken().trim();
					postcode = st.nextToken().trim();
					


				}
				addresses.put(Integer.parseInt(id), new Address(Integer.parseInt(id),street,number,city,Integer.parseInt(postcode)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( in != null ) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
		
	}

}
