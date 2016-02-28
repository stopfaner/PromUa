package ua.prom.resources;

import ua.prom.core.EntityConfig;
import ua.prom.models.Company;
import ua.prom.models.Group;
import ua.prom.models.Product;
import ua.prom.models.ProductId;
import ua.prom.services.ProductService;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by denys on 28.02.16.
 */
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductService service = ProductService.getService();

    private EntityManager eManager;

    @GET
    @Path("/products")
    public List<Product> getProducts(@QueryParam("id") Long companyId,
                                     @QueryParam("limit") int limit,
                                     @QueryParam("offset") int offset) {
        if (service == null)
            service = ProductService.getService();
        return service.searchProductsById(companyId, limit, offset);
    }

    @GET
    @Path("/group")
    public Group getGroup(@QueryParam("id") Long id) {
        if (service == null)
            service = ProductService.getService();
        return service.getGroupById(id);
    }

    @GET
    @Path("/product")
    public ProductId getProductById(@QueryParam("id") Long id) {
        if (service == null)
            service = ProductService.getService();
        return service.getProductById(id);
    }

    @GET
    @Path("/tag")
    public List<Product> getProductByTag(@QueryParam("tag") String pattern,
                                         @QueryParam("limit") int limit,
                                         @QueryParam("offset") int offset) {
        if (service == null)
            service = ProductService.getService();
        return service.getProductByTag(pattern, limit, offset);
    }


}
