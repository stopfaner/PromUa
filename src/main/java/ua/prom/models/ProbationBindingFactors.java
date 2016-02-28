package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 27.02.16.
 */
@Entity
@XmlRootElement
@Table(name = "test_filter")
public class ProbationBindingFactors {

    @Column (name = "agency_id")
    private Long id;

    public ProbationBindingFactors() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
