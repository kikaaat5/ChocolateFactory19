package dao;
import java.io.BufferedReader;

import beans.Chocolate;
import beans.ChocolateStatus;
import beans.ChocolateType;
import beans.Species;
import java.util.HashMap;


public class ChocolateDAO {
private HashMap<String, Chocolate> chocolates = new HashMap<String, Chocolate>();
	
	public ChocolateDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public ChocolateDAO(String contextPath) {
		loadChocolates(contextPath);
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<Chocolate> findAll() {
		return chocolates.values();
	}

	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public Chocolate findChocolate(String id) {
		return chocolates.containsKey(id) ? chocolates.get(id) : null;
	}
	
	public Chocolate updateChocolate(String id, Chocolate chocolate) {
		Chocolate c = chocolates.containsKey(id) ? chocolates.get(id) : null;
		if (c == null) {
			return save(chocolate);
		} else {
			c.setName(chocolate.getName());
			c.setPrice(chocolate.getPrice());
		}
		
		return c;
	}
	
    public Chocolate deleteChocolate(String id) {
//      for (ArrayList<Chocolate> chocolates : chocolatesByFactory.values()) {
//          for (Chocolate chocolate : chocolates) {
//              if (chocolate.getId().equals(id)) {
//                  chocolates.remove(chocolate);
//                  chocolates.remove(id);
//                  saveChocolatesToFile();
//                  return chocolate;
//              }
//          }
//      }
  	/*Chocolate chocolate = chocolates.get(id);
  	chocolate.setDeleted(true);
  	chocolates.put(id, chocolate);
  	saveChocolatesToFile();
  	return chocolate;*/
  }
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param product
	 */
	public Chocolate save(Chocolate chocolate) {
		Integer maxId = -1;
		for (String id : chocolates.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		chocolate.setId(maxId.toString());
		chocolates.put(chocolate.getId(), chocolate);
		return chocolate;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #products}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadChocolates(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/chocolates.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", name = "", price = "", species="", chocolateType="", weight="", description="", image="", status="" ;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					name = st.nextToken().trim();
					price = st.nextToken().trim();
					species = Species.parse( st.nextToken().trim());
					chocolateType = ChocolateType.parse(st.nextToken().trim());
					weight = st.nextToken().trim();
					description = st.nextToken().trim();
					image = st.nextToken().trim();
					status = ChocolateStatus.parse(st.nextToken().trim());
				}
				chocolates.put(id, new Chocolate(id, name, Double
						.parseDouble(price), species, chocolateType, Double.parseDouble(weight), description, image, status ));
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
