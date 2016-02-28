package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 27.02.16.
 */
@Entity
@Table(name = "company_filtered")
@XmlRootElement
@NamedQuery(name = "Companies.getAll", query = "SELECT c FROM Company c")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    public Company() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
