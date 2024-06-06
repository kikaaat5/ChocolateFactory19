package dao;

import beans.ShoppingCart;
import beans.User;

public class ShoppingCartDAO {
private HashMap<String, ShoppingCart> ShoppingCarts = new HashMap<String, ShoppingCart>();
	
	public ShoppingCartDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public ShoppingCartDAO(String contextPath) {
		loadShoppingCarts(contextPath);
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<ShoppingCart> findAll() {
		return ShoppingCarts.values();
	}

	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public ShoppingCart findShoppingCart(String id) {
		return ShoppingCarts.containsKey(id) ? ShoppingCarts.get(id) : null;
	}
	
	public ShoppingCart updateShoppingCart(String id, ShoppingCart ShoppingCart) {
		ShoppingCart p = ShoppingCarts.containsKey(id) ? ShoppingCarts.get(id) : null;
		if (p == null) {
			return save(ShoppingCart);
		} else {
			p.setName(ShoppingCart.getName());
			p.setPrice(ShoppingCart.getPrice());
		}
		
		return p;
	}
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param ShoppingCart
	 */
	public ShoppingCart save(ShoppingCart ShoppingCart) {
		Integer maxId = -1;
		for (String id : ShoppingCarts.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		ShoppingCart.setId(maxId.toString());
		ShoppingCarts.put(ShoppingCart.getId(), ShoppingCart);
		return ShoppingCart;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #ShoppingCarts}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadShoppingCarts(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/ShoppingCarts.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", user = "", price = "";
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					user = User.parse(st.nextToken().trim());
					price = st.nextToken().trim();
				}
				ShoppingCarts.put(id, new ShoppingCart(id, user, Double
						.parseDouble(price)));
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
