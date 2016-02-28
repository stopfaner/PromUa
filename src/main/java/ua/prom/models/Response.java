package ua.prom.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denys on 28.02.16.
 */
@XmlRootElement
public class Response <T> {

    @XmlElement (name = "message")
    private T message;

    @XmlElement (name = "status")
    private String status;

    public Response() {

    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
