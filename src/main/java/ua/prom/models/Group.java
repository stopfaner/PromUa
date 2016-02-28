package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 27.02.16.
 */
@Entity
@Table(name = "group_filtered")
@XmlRootElement
//@NamedQuery(name = "Groups.getAll", query = "SELECT c FROM product_group c")
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "company_id")
    private Long companyId;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
