package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by denys on 27.02.16.
 */
@Entity
@Table (name = "product_category")
@XmlRootElement
@NamedQuery(name = "Categories.getAll", query = "SELECT c FROM product_category c")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




}
