package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.Factory;
import beans.Location;
import beans.Product;

public class LocationDAO {
	
	public HashMap<Integer,Location> locations = new HashMap<Integer,Location>();

	
	public LocationDAO() {
		// TODO Auto-generated constructor stub
	}
	public LocationDAO(String contextPath) {
		loadLocations(contextPath);
	}
	
	
	public Collection<Location> getAll() {
		return locations.values();
	}
	
	public Location findById(int id) {
		  if(locations.containsKey(id)){
			  return locations.get(id);
		  }
		  return new Location();
	}
	
	private void loadLocations(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/locations.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", longitude = "", latitude = "", addressId="";
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					longitude = st.nextToken().trim();
					latitude = st.nextToken().trim();
					addressId = st.nextToken().trim();
					

				}
				locations.put(Integer.parseInt(id), new Location(Integer.parseInt(id),Double
						.parseDouble(longitude),Double
						.parseDouble(latitude),Integer.parseInt(addressId)));
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
