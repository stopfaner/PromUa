package ua.prom.services;

import ua.prom.core.EntityConfig;
import ua.prom.models.Company;
import ua.prom.models.Group;
import ua.prom.models.Product;
import ua.prom.models.ProductId;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 27.02.16.
 */
public class ProductService {

    private static ProductService service;
    private EntityManager eManager;

    private ProductService() {
        eManager = EntityConfig.getInstance();
    }

    public static synchronized ProductService getService() {
        if (service == null)
            service = new ProductService();

        return service;
    }

    public List<Product> searchProductsById(Long companyId, int limit, int offset) {
        TypedQuery<Product> query = eManager.createQuery(
                "SELECT c FROM Product c WHERE c.companyId = :idc", Product.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setParameter("idc", companyId);

        return query.getResultList();
    }

    public Group getGroupById(Long id) {
        return eManager.find(Group.class, id);
    }

    public ProductId getProductById(Long id) {
        return eManager.find(ProductId.class, id);
    }

    public List<Product> getProductByTag(String pattern, int limit, int offset) {
        TypedQuery<Product> query = eManager.createQuery(
                "SELECT c FROM Product c WHERE c.keyWords LIKE :pattern", Product.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setParameter("pattern", "%" + pattern + "%");

        return query.getResultList();
    }

}
