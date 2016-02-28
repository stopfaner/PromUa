package ua.prom.resources;

import ua.prom.core.EntityConfig;
import ua.prom.models.Company;
import ua.prom.models.Product;
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
    @Path("/count")
    public Long getProductsCount (@QueryParam("id") Long companyId) {
        if (service == null)
            service = ProductService.getService();
        return service.getProductCount(companyId);
    }

    @GET
    @Path("/single")
    public Product getMessage(@QueryParam("id") Long id) {
        if (eManager == null)
            eManager = EntityConfig.getInstance();
        Product singleProduct;
        try {
            singleProduct = eManager.find(Product.class, id);
        } catch (NullPointerException ex) {
            singleProduct = new Product();
        }
        return singleProduct;
    }

    @GET
    @Path("/company")
    public Company getCompany() {
        if (eManager == null)
            eManager = EntityConfig.getInstance();
        return eManager.find(Company.class, new Long(132569));
    }



}
