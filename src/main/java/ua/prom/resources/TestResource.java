package ua.prom.resources;

import ua.prom.core.EntityConfig;
import ua.prom.models.Product;
import ua.prom.services.ProductService;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 27.02.16.
 */
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@XmlRootElement
public class TestResource {

    private ProductService service = ProductService.getService();

    private EntityManager eManager;

    @GET
    @Path("/single")
    public Product getMessage(@QueryParam("id") Long id) {
        if (eManager == null)
            eManager = EntityConfig.getInstance();
        Product test = eManager.find(Product.class, id);

        return test ;
    }

}
