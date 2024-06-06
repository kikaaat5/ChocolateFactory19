package dao;

import beans.Factory;
import beans.Shopping;
import beans.ShoppingStatus;

public class ShoppingDAO {
	private HashMap<String, Shopping> Shoppings = new HashMap<String, Shopping>();
	
	public ShoppingDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public ShoppingDAO(String contextPath) {
		loadShoppings(contextPath);
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<Shopping> findAll() {
		return Shoppings.values();
	}

	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public Shopping findShopping(String id) {
		return Shoppings.containsKey(id) ? Shoppings.get(id) : null;
	}
	
	public Shopping updateShopping(String id, Shopping Shopping) {
		Shopping p = Shoppings.containsKey(id) ? Shoppings.get(id) : null;
		if (p == null) {
			return save(Shopping);
		} else {
			p.setName(Shopping.getName());
			p.setPrice(Shopping.getPrice());
		}
		
		return p;
	}
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param Shopping
	 */
	public Shopping save(Shopping Shopping) {
		Integer maxId = -1;
		for (String id : Shoppings.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		Shopping.setId(maxId.toString());
		Shoppings.put(Shopping.getId(), Shopping);
		return Shopping;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #Shoppings}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadShoppings(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/Shoppings.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", factory = "", date = "", price="", user="", shoppingStatus="";
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					factory = Factory.parse(st.nextToken().trim());
					date = DateTime.parse(st.nextToken().trim());
					price = st.nextToken().trim();
					user = User.parse(st.nextToken().trim());
					shoppingStatus = ShoppingStatus.parse(st.nextToken().trim());
				}
				Shoppings.put(id, new Shopping(id, factory, date, Double.parseDouble(price), user, shoppingStatus));
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
