package ua.prom.services;

import ua.prom.core.EntityConfig;
import ua.prom.models.Company;
import ua.prom.models.Product;

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

    public Long getProductCount(Long companyId) {
        CriteriaBuilder criteriaBuilder = eManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Product.class)));
        Root<Product> from = criteriaQuery.from(Product.class);
        Predicate condition = criteriaBuilder.equal(from.get("companyId"), companyId);
        criteriaQuery.where(condition);

        return eManager.createQuery(criteriaQuery).getSingleResult();
    }

}
