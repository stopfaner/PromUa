package ua.prom.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 28.02.16.
 */
@Entity
@Table(name = "product_id")
@XmlRootElement
public class ProductId {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column (name = "html_long_description")
    private String html;

    public ProductId() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
