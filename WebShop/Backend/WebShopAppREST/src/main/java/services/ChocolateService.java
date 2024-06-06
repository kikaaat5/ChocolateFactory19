package services;

import beans.Chocolate;
import dao.ChocolateDAO;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/chocolates")
public class ChocolateService {
    @Context
    ServletContext ctx;

    @PostConstruct
    public void init() {
        if (ctx.getAttribute("chocolateDAO") == null) {
            ctx.setAttribute("chocolateDAO", new ChocolateDAO(ctx.getRealPath("/")));
        }
    }

    @GET
    @Path("/factory/{factoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Chocolate> getChocolatesByFactory(@PathParam("factoryId") String factoryId) {
        ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
        return dao.getChocolatesByFactory(factoryId);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chocolate getChocolateById(@PathParam("id") String id) {
        ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
        return dao.getChocolateById(id);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Chocolate addChocolate(Chocolate chocolate) {
        ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
        return dao.saveChocolate(chocolate);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Chocolate updateChocolate(@PathParam("id") String id, Chocolate updatedChocolate) {
        ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
        return dao.updateChocolate(id, updatedChocolate);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chocolate deleteChocolate(@PathParam("id") String id) {
        ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
        return dao.deleteChocolate(id);
    }
}
