package dao;

import beans.Comment;
import beans.Factory;

public class CommentDAO {
	private HashMap<String, Comment> Comments = new HashMap<String, Comment>();
	
	public CommentDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public CommentDAO(String contextPath) {
		loadComments(contextPath);
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<Comment> findAll() {
		return Comments.values();
	}

	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public Comment findComment(String id) {
		return Comments.containsKey(id) ? Comments.get(id) : null;
	}
	
	public Comment updateComment(String id, Comment Comment) {
		Comment p = Comments.containsKey(id) ? Comments.get(id) : null;
		if (p == null) {
			return save(Comment);
		} else {
			p.setName(Comment.getName());
			p.setPrice(Comment.getPrice());
		}
		
		return p;
	}
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param Comment
	 */
	public Comment save(Comment Comment) {
		Integer maxId = -1;
		for (String id : Comments.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		Comment.setId(maxId.toString());
		Comments.put(Comment.getId(), Comment);
		return Comment;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #Comments}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadComments(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/Comments.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			String line, id = "", factory = "", comment = "", grade="";
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
					factory = Factory.parse(st.nextToken().trim());
					comment = st.nextToken().trim();
					grade = st.nextToken().trim();
				}
				Comments.put(id, new Comment(id, factory, comment, Double
						.parseDouble(grade)));
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
