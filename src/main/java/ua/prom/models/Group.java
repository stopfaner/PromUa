package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 27.02.16.
 */
@Entity
@Table(name = "product_group")
@XmlRootElement
@NamedQuery(name = "Groups.getAll", query = "SELECT c FROM product_group c")
public class Group {

    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Company company;

    public Group() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
