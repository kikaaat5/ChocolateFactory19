package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Address;
import beans.Factory;
import beans.Location;
import dao.AddressDAO;
import dao.FactoryDAO;
import dao.LocationDAO;

@Path("/factories")
public class FactoryService {
	@Context
	ServletContext ctx;
	@Context
	ServletContext ctx1;
	@Context
	ServletContext ctx2;
	
	public FactoryService() {
		
	}
	
	@PostConstruct
	// ctx polje je null u konstruktoru, mora se pozvati nakon konstruktora (@PostConstruct anotacija)
	public void init() {
		// Ovaj objekat se instancira vise puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("factoryDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("factoryDAO", new FactoryDAO(contextPath));
		}
		if (ctx.getAttribute("locationDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("locationDAO", new LocationDAO(contextPath));
		}
		if (ctx.getAttribute("addressDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("addressDAO", new AddressDAO(contextPath));
		}
		
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Factory> getFactories() {
		FactoryDAO dao = (FactoryDAO) ctx.getAttribute("factoryDAO");
		LocationDAO locDao = (LocationDAO) ctx.getAttribute("locationDAO");
		AddressDAO adrDao = (AddressDAO) ctx.getAttribute("addressDAO");
		Collection<Factory> all= dao.getAll();
		Collection<Location>allLoc = locDao.getAll();
		for(Location l:allLoc) {
			l.setAddress(adrDao.findById(l.getAddressId()));
		}
		
		for (Factory f:all) {
			Location l = locDao.findById(f.getLocationId());
			Address a= l.getAddress();
			f.setLocation(l);
			f.setLocationStr(a.getStreet()+" "+a.getNumber()+" ,     "+a.getCity()
								+" "+a.getPostCode()+" ,      "+l.getLongitude()+" "+l.getLatitude());
		}
		return all;
	}
	
	  @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getFactory(@PathParam("id") String id) {
		  FactoryDAO dao = (FactoryDAO) ctx.getAttribute("factoryDAO");
		  LocationDAO locDao = (LocationDAO) ctx.getAttribute("locationDAO");
		  AddressDAO adrDao = (AddressDAO) ctx.getAttribute("addressDAO");
	        Factory factory = dao.findById(id);
	        
	        factory.setLocation(locDao.findById(factory.getLocationId()));
	        factory.getLocation().setAddress(adrDao.findById(factory.getLocation().getAddressId()));
	        if (factory != null) {
	            return Response.ok(factory).build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).build();
	        }
	    }
	
	

}
