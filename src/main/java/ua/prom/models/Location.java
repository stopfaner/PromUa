package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by denys on 27.02.16.
 */

@Entity
@XmlRootElement
@Table(name = "location")
//@NamedQuery(name = "location.getAll", query = "SELECT c FROM Lo c")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "country_id")
    private long countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    public Location() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
